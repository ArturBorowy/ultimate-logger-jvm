package pl.arturborowy.logger

class TagBuilder(private val stackTraceElementReceiver: StackTraceElementReceiver,
                 private val defaultTagSettings: TagSettings) {

    companion object {
        private const val PACKAGE_SEPARATOR = '.'
    }

    fun build(withFileNme: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?,
              withLineNumber: Boolean?): String {
        val stackTraceElement =
                javaClass.canonicalName?.let { stackTraceElementReceiver.getData() }

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

    fun buildForThrowable() =
            build(withFileNme = true,
                    withClassName = false,
                    withMethodName = false,
                    withLineNumber = false)

    private fun build(stackTraceElement: StackTraceElement,
                      withFileNme: Boolean,
                      withClassName: Boolean,
                      withMethodName: Boolean,
                      withLineNumber: Boolean): String {
        val fileName = getTagElement(withFileNme, stackTraceElement.fileName)

        val lineNumberStr = getTagElement(withLineNumber,
                stackTraceElement.lineNumber.toString())

        val className = getTagElement(withClassName,
                removePackageFromClassName(stackTraceElement.className))

        val methodName = getTagElement(withMethodName,
                ".${stackTraceElement.methodName}()")

        return "($fileName:$lineNumberStr)$className$methodName"
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