package com.ultimatelogger.multiplatform.tag.dataprovider

internal class TagDataConverter {

    fun fromStackTraceElement(stackTraceElement: StackTraceElement) =
            TagData(stackTraceElement.fileName,
                    stackTraceElement.className,
                    stackTraceElement.methodName,
                    stackTraceElement.lineNumber.toString())
}
