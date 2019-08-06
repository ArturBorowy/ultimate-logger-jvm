package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.tag.TagSettings

interface UltimateLoggerInitializer {

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings)

    fun destroy() = MpUltimateLoggerInitializer.destroy()
}