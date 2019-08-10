package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.tag.TagSettings

interface UltimateLoggerInitializer {

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings)

    fun destroy() = MpUltimateLoggerInitializer.destroy()
}