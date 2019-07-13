package pl.arturborowy.logger.tag

import pl.arturborowy.logger.UltLog
import pl.arturborowy.logger.data.TagSettingsRepository

class StackTraceElementReceiver(private val tagSettingsRepository: TagSettingsRepository) {

    fun getData(vararg classNamesToIgnore: String): StackTraceElement? {
        val stElements = Thread.currentThread().stackTrace
        for (i in 1 until stElements.size) {
            val ste = stElements[i]
            if (ste.className != this::class.qualifiedName
                    && ste.className.indexOf("java.lang.Thread") != 0
                    && classNamesToIgnore.contains(ste.className).not()
                    && ste.className != UltLog::class.qualifiedName) {
                return ste
            }
        }
        return null
    }
}