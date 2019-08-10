package com.ultimatelogger.multiplatform

import com.ultimatelogger.tagsettings.TagSettings

interface UltimateLoggerInitializer {

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings)

    fun destroy() = MpUltimateLoggerInitializer.destroy()
}