package pl.arturborowy.androidloggeroutput

import pl.arturborowy.ultimatelogger.UltLogInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

object AndroidUltLogInitializer {

    fun init(isDebug: Boolean,
             defaultTagSettings: TagSettings) {
        UltLogInitializer.initDebug(isDebug, defaultTagSettings, AndroidLog())
    }
}