package pl.arturborowy.logger

class TagBuilder(private val stackTraceElementReceiver: StackTraceElementReceiver,
                 private val defaultTagSettings: TagSettings) {

    fun build(withFileNme: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?,
              withLineNumber: Boolean?): String {
        val stackTraceElement = stackTraceElementReceiver.getData(javaClass.canonicalName!!)

        return if (stackTraceElement == null) {
            ""
        } else {
            build(stackTraceElement,
                    withFileNme ?: defaultTagSettings.shouldLogFileName,
                    withClassName ?: defaultTagSettings.shouldLogClassName,
                    withMethodName ?: defaultTagSettings.shouldLogMethodName,
                    withLineNumber ?: defaultTagSettings.shouldLogLineNr)
        }
    }

    private fun build(stackTraceElement: StackTraceElement,
                      withFileNme: Boolean,
                      withClassName: Boolean,
                      withMethodName: Boolean,
                      withLineNumber: Boolean): String {
        val fileName = getTagElement(withFileNme, "${stackTraceElement.fileName} ")
        val className = getTagElement(withClassName, stackTraceElement.className)

        val methodName = getTagElement(withMethodName,
                ".${stackTraceElement.methodName}()")

        val lineNumberStr = getTagElement(withLineNumber,
                " Line: ${stackTraceElement.lineNumber}")

        return "$fileName$className$methodName$lineNumberStr"
    }

    private fun getTagElement(isElementIncluded: Boolean, element: String) =
            if (isElementIncluded) {
                element
            } else {
                ""
            }
}