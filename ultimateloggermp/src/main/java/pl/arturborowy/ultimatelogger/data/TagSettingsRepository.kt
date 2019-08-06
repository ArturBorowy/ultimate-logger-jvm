package pl.arturborowy.ultimatelogger.data

import pl.arturborowy.ultimatelogger.exception.UltimateLoggerNotInitializedException
import pl.arturborowy.ultimatelogger.tag.TagSettings

internal class TagSettingsRepository {

    var defaultTagSettings: TagSettings
        get() = defaultTagSettingsInternal ?: throw UltimateLoggerNotInitializedException()
        set(value) {
            defaultTagSettingsInternal = value
        }

    private var defaultTagSettingsInternal: TagSettings? = null
}