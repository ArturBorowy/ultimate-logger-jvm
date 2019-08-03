package pl.arturborowy.ultimatelogger.tag.dataprovider

class TagDataConverter {

    fun fromStackTraceElement(stackTraceElement: StackTraceElement) =
            TagData(stackTraceElement.fileName,
                    stackTraceElement.className,
                    stackTraceElement.methodName,
                    stackTraceElement.lineNumber.toString())
}
