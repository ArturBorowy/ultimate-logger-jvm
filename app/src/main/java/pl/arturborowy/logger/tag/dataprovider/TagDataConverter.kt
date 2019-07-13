package pl.arturborowy.logger.tag.dataprovider

class TagDataConverter {

    fun fromStackTraceElement(stackTraceElement: StackTraceElement) =
            TagData(stackTraceElement.fileName,
                    stackTraceElement.className,
                    stackTraceElement.methodName,
                    stackTraceElement.lineNumber.toString())
}
