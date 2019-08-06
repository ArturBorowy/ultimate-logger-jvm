package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.ultimatelogger.MpUltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.UltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.di.JvmLog
import pl.arturborowy.ultimatelogger.tag.TagSettings

object JvmUltLogInitializer : UltimateLoggerInitializer {

    override fun init(shouldLog: Boolean,
                      defaultTagSettings: TagSettings) {
        val ultimateLogger = lazy { JvmLog }
        MpUltimateLoggerInitializer.init(shouldLog,
                defaultTagSettings,
                ultimateLogger,
                SystemOutPrintLogger())
    }
}