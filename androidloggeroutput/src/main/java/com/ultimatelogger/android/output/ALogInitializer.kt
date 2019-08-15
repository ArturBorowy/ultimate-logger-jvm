package com.ultimatelogger.android.output

import android.os.Build
import com.ultimatelogger.android.output.tag.AndroidTagCutter
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
                buildAndroidOutput()
        )
    }

    private fun buildAndroidOutput() =
            MessageParsingMultiPriorityLogger(
                    TagLimitMultiPriorityLogger(
                            AndroidLog(),
                            AndroidTagCutter(Build.VERSION.SDK_INT)
                    ),
                    MessageForThrowableLogParser()
            )
}