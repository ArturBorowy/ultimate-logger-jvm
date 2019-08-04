package pl.arturborowy.androidloggeroutput

import android.content.Context
import pl.arturborowy.ultimatelogger.UltLogInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

object AndroidUltLogInitializer {

    fun init(context: Context,
             isDebug: Boolean,
             defaultTagSettings: TagSettings) {
        UltLogInitializer.initDebug(isDebug, defaultTagSettings, AndroidLog())
    }
}