package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

import pl.arturborowy.ultimatelogger.data.TagSettingsRepository

internal class ClassIgnorableStackTraceElementProvider(tagSettingsRepository: TagSettingsRepository) :
        StackTraceElementProvider {

    private val classesToIgnore =
            tagSettingsRepository.defaultTagSettings.classesToIgnore

    private val namesOfClassesToIgnore = classesToIgnore.map { it.qualifiedName }

    override fun getStackTraceElement(): StackTraceElement? {
        val stElements = Thread.currentThread().stackTrace
        for (i in 1 until stElements.size) {
            val ste = stElements[i]
            if (namesOfClassesToIgnore.contains(ste.className).not()
                    && namesOfClassesToIgnore.map { "$it\$DefaultImpls" }.contains(ste.className).not()
                    && ste.className.contains("pl.arturborowy.ultimatelogger").not()
                    && ste.className.indexOf("java.lang.Thread") != 0) {
                return ste
            }
        }
        return null
    }
}