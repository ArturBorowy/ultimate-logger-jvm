package pl.arturborowy.androidloggeroutput

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.MpUltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.UltimateLoggerInitializer

object AndroidUltLogInitializer : UltimateLoggerInitializer {

    override fun init(shouldLog: Boolean,
                      defaultTagSettings: TagSettings) {
        val ultimateLogger = lazy { ALog }
        MpUltimateLoggerInitializer.init(shouldLog,
                defaultTagSettings,
                ultimateLogger,
                AndroidLog())
    }
}