package pl.arturborowy.ultimatelogger.data

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.exception.UltimateLoggerNotInitializedException

internal class TagSettingsRepository {

    var defaultTagSettings: TagSettings
        get() = defaultTagSettingsInternal ?: throw UltimateLoggerNotInitializedException()
        set(value) {
            defaultTagSettingsInternal = value
        }

    private var defaultTagSettingsInternal: TagSettings? = null
}