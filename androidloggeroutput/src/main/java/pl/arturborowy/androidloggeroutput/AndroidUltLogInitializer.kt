package pl.arturborowy.androidloggeroutput

import pl.arturborowy.ultimatelogger.MpUltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.UltimateLoggerInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

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