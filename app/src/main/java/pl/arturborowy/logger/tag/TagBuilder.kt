package pl.arturborowy.logger.tag

import pl.arturborowy.logger.data.TagSettingsRepository

class TagBuilder(private val stackTraceElementReceiver: StackTraceElementReceiver,
                 private val tagSettingsRepository: TagSettingsRepository) {

    companion object {
        private const val PACKAGE_SEPARATOR = '.'
    }

    private val defaultTagSettings = tagSettingsRepository.defaultTagSettings

    fun build(withFileNameAndLineNr: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String {
        val stackTraceElement = stackTraceElementReceiver.getData()

        return if (stackTraceElement == null) {
            ""
        } else {
            build(stackTraceElement,
                    withFileNameAndLineNr ?: defaultTagSettings.shouldLogFileNameAndLineNr,
                    withClassName ?: defaultTagSettings.shouldLogClassName,
                    withMethodName ?: defaultTagSettings.shouldLogMethodName)
        }
    }

    fun buildForThrowable() =
            build(withFileNameAndLineNr = true,
                    withClassName = false,
                    withMethodName = false)

    private fun build(stackTraceElement: StackTraceElement,
                      withFileNameAndLineNr: Boolean,
                      withClassName: Boolean,
                      withMethodName: Boolean): String {
        val fileNameWithLineNr = getTagElement(withFileNameAndLineNr, "(${stackTraceElement.fileName}:${stackTraceElement.lineNumber})")

        val className = getTagElement(withClassName,
                removePackageFromClassName(stackTraceElement.className))

        val methodName = getTagElement(withMethodName,
                ".${stackTraceElement.methodName}()")

        val output = "$fileNameWithLineNr $className$methodName"

        return if (output == " ") {
            " "
        } else {
            output.removePrefix(" ").removeSuffix(" ")
        }
    }

    private fun removePackageFromClassName(classWithPackage: String) =
            classWithPackage.substring(classWithPackage.indexOfLast { it == PACKAGE_SEPARATOR } + 1)

    private fun getTagElement(isElementIncluded: Boolean, element: String) =
            if (isElementIncluded) {
                element
            } else {
                ""
            }
}