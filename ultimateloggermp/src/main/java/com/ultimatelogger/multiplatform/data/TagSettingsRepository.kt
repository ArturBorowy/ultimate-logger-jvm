package com.ultimatelogger.multiplatform.data

import com.ultimatelogger.multiplatform.exception.UltimateLoggerNotInitializedException
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.util.CryptoNullable

internal class TagSettingsRepository {

    var defaultTagSettings: TagSettings by CryptoNullable(UltimateLoggerNotInitializedException())
}