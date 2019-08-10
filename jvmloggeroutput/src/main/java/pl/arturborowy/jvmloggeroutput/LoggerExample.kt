package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.tw

internal fun main(args: Array<String>) {
    JvmUltLogInitializer.init(true,
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

    (null as String?).tw {  }
}