package com.ultimatelogger.multiplatform.util

import com.ultimatelogger.multiplatform.tag.dataprovider.TagData

internal object TestData {

    fun getTagData() =
            TagData("fileName",
                    "className",
                    "methodName",
                    "12")

    fun getStackTrace() =
            listOf(
                    StackTraceElement("Class1", "Method1", "File1", 1),
                    StackTraceElement("Class2", "Method2", "File2", 2),
                    StackTraceElement("Class3", "Method3", "File3", 3),
                    StackTraceElement("Class4", "Method4", "File4", 4),
                    StackTraceElement("Class5", "Method5", "File5", 5)
            )

    fun getStackTraceWithElementsShouldBeIgnored() =
            listOf(
                    StackTraceElement("dalvik.system.VMStack", "Method3", "File3", 1),
                    StackTraceElement("com.ultimatelogger.android.output.Class3", "Method3", "File3", 2),
                    StackTraceElement("java.lang.Thread", "Method3", "File3", 3),
                    StackTraceElement("Class4", "Method4", "File4", 4),
                    StackTraceElement("Class5", "Method5", "File5", 5),
                    StackTraceElement("Class6", "Method6", "File6", 6),
                    StackTraceElement("Class7", "Method7", "File7", 7),
                    StackTraceElement("Class8", "Method8", "File8", 8),
                    StackTraceElement("com.ultimatelogger.jvm.output.Class3", "Method3", "File3", 9),
                    StackTraceElement("com.ultimatelogger.multiplatform.Class3", "Method3", "File3", 10)
            )
}