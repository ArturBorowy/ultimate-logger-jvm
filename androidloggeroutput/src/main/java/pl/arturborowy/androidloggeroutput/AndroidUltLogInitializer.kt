package pl.arturborowy.androidloggeroutput

import pl.arturborowy.ultimatelogger.UltLogInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

object AndroidUltLogInitializer {

    fun init(isDebug: Boolean,
             defaultTagSettings: TagSettings) {
        val ultLog = lazy { ALog }
        UltLogInitializer.initDebug(isDebug, defaultTagSettings, ultLog, AndroidLog())
    }

    fun destroy() = UltLogInitializer.destroy()
}