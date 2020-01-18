package com.ultimatelogger.jvm.example

import com.ultimatelogger.jvm.output.JvmLog
import com.ultimatelogger.jvm.output.JvmLogInitializer
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.tw

var loggingObject = LoggingClass()
set(value) {
    JvmLog.d("SomeMsg")
}
get() {
    JvmLog.d("SomeMsg")
    return field
}

internal fun main(args: Array<String>) {
    JvmLogInitializer.init(true,
            TagSettings(shouldLogThreadName = true,
                    shouldLogFileNameAndLineNum = true,
                    shouldLogClassName = true,
                    shouldLogMethodName = true))

    Thread({ JvmLog.v("JvmLog.v")}, "THREAD NAMED").start()

    JvmLog.v("JvmLog.v")
    JvmLog.v(Exception())
    JvmLog.v(Any())
    JvmLog.d("JvmLog.d")
    JvmLog.d(Exception())
    JvmLog.d(Any())
    JvmLog.i("JvmLog.i")
    JvmLog.i(Exception())
    JvmLog.i(Any())
    JvmLog.w("JvmLog.w")
    JvmLog.w(Exception())
    JvmLog.w(Any())
    JvmLog.e("JvmLog.e")
    JvmLog.e(Exception())
    JvmLog.e(Any())
    JvmLog.wtf("JvmLog.wtf")
    JvmLog.wtf(Exception())
    JvmLog.wtf(Any())

    (null as String?).tw { }

    loggingFunction()
    loggingFunctionInline()

    LoggingClass() loggingMethodInfix 2
    LoggingClass().loggingMethod()

    loggingObject
    loggingObject = LoggingClass()
    loggingObject.loggingExtension()
    LoggingObject loggingMethodInfix 2
    LoggingObject.loggingMethod()
}

object LoggingObject {

    init {
        JvmLog.d("SomeMsg")
    }

    infix fun loggingMethodInfix(int : Int) =JvmLog.d("SomeMsg")

    fun loggingMethod() =JvmLog.d("SomeMsg")
}

class LoggingClass {

    infix fun loggingMethodInfix(int : Int) =JvmLog.d("SomeMsg")

     fun loggingMethod() =JvmLog.d("SomeMsg")
}

private fun LoggingClass.loggingExtension() = JvmLog.d("SomeMsg")

private inline fun loggingFunctionInline()=JvmLog.d("SomeMsg")

private fun loggingFunction() =JvmLog.d("SomeMsg")
