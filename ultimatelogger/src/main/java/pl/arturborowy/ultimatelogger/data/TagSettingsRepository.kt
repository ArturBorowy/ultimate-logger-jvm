package pl.arturborowy.ultimatelogger.data

import pl.arturborowy.ultimatelogger.exception.UltLogNotInitializedException
import pl.arturborowy.ultimatelogger.tag.TagSettings

class TagSettingsRepository {

    var defaultTagSettings: TagSettings
        get() = defaultTagSettingsInternal ?: throw UltLogNotInitializedException()
        set(value) {
            defaultTagSettingsInternal = value
        }

    private var defaultTagSettingsInternal: TagSettings? = null
}