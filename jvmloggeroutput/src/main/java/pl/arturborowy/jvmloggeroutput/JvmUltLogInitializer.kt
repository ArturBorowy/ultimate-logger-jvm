package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.MpUltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.UltimateLoggerInitializer

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