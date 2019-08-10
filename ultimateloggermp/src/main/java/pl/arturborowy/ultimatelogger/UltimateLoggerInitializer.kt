package pl.arturborowy.ultimatelogger

import pl.arturborowy.tagsettings.TagSettings

interface UltimateLoggerInitializer {

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings)

    fun destroy() = MpUltimateLoggerInitializer.destroy()
}