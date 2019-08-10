package com.ultimatelogger.jvm.example

import com.ultimatelogger.jvm.output.JvmLog
import com.ultimatelogger.jvm.output.JvmLogInitializer
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.tw

internal fun main(args: Array<String>) {
    JvmLogInitializer.init(true,
            TagSettings(shouldLogFileNameAndLineNum = true,
                    shouldLogClassName = true,
                    shouldLogMethodName = true))

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
}