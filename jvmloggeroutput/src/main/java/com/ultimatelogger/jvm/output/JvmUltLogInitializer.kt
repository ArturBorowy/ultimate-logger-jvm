package com.ultimatelogger.jvm.output

import com.ultimatelogger.multiplatform.MpUltimateLoggerInitializer
import com.ultimatelogger.multiplatform.UltimateLoggerInitializer
import com.ultimatelogger.multiplatform.tag.TagSettings

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