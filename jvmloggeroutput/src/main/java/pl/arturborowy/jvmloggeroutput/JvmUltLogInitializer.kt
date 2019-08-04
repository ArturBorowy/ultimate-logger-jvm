package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.ultimatelogger.UltLogInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

object JvmUltLogInitializer {

    fun init(isDebug: Boolean,
             defaultTagSettings: TagSettings) {
        UltLogInitializer.initDebug(isDebug, defaultTagSettings, SystemOutPrintLogger())
    }

    fun destroy() = UltLogInitializer.destroy()
}