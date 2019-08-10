package com.ultimatelogger.jvm.output

import com.ultimatelogger.tagsettings.TagSettings
import com.ultimatelogger.multiplatform.MpUltimateLoggerInitializer
import com.ultimatelogger.multiplatform.UltimateLoggerInitializer

object JvmUltLogInitializer : UltimateLoggerInitializer {

    override fun init(shouldLog: Boolean,
                      defaultTagSettings: TagSettings) {
        val ultimateLogger = lazy { JvmLog }
        MpUltimateLoggerInitializer.init(shouldLog,
                defaultTagSettings,
                ultimateLogger,
                SystemOutPrintLogger())
    }
}