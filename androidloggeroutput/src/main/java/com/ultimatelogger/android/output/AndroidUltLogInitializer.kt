package com.ultimatelogger.android.output

import com.ultimatelogger.tagsettings.TagSettings
import com.ultimatelogger.multiplatform.MpUltimateLoggerInitializer
import com.ultimatelogger.multiplatform.UltimateLoggerInitializer

object AndroidUltLogInitializer : UltimateLoggerInitializer {

    override fun init(shouldLog: Boolean,
                      defaultTagSettings: TagSettings) {
        val ultimateLogger = lazy { ALog }
        MpUltimateLoggerInitializer.init(shouldLog,
                defaultTagSettings,
                ultimateLogger,
                MessageParsingMultiPriorityLogger(AndroidLog(), MessageForThrowableLogParser()))
    }
}