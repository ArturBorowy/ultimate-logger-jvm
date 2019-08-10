package com.ultimatelogger.android.output

import com.ultimatelogger.multiplatform.MpUltimateLoggerInitializer
import com.ultimatelogger.multiplatform.UltimateLoggerInitializer
import com.ultimatelogger.multiplatform.tag.TagSettings

object ALogInitializer : UltimateLoggerInitializer {

    override fun init(shouldLog: Boolean,
                      defaultTagSettings: TagSettings) {
        val ultimateLogger = lazy { ALog }
        MpUltimateLoggerInitializer.init(shouldLog,
                defaultTagSettings,
                ultimateLogger,
                MessageParsingMultiPriorityLogger(AndroidLog(), MessageForThrowableLogParser()))
    }
}