package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.ultimatelogger.UltLog
import pl.arturborowy.ultimatelogger.tag.TagSettings

internal fun main(args: Array<String>) {
    JvmUltLogInitializer.init(true,
            TagSettings(shouldLogFileNameAndLineNum = true,
                    shouldLogClassName = true,
                    shouldLogMethodName = true))
    UltLog.e("EBEBEBEBBE")
    UltLog.e(Exception())
}