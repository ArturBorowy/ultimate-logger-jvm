package pl.arturborowy.ultimatelogger.data

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.exception.UltimateLoggerNotInitializedException
import pl.arturborowy.ultimatelogger.util.CryptoNullable

internal class TagSettingsRepository {

    var defaultTagSettings: TagSettings by CryptoNullable(UltimateLoggerNotInitializedException())
}