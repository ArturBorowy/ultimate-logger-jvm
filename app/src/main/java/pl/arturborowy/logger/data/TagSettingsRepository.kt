package pl.arturborowy.logger.data

import pl.arturborowy.logger.exception.UltLogNotInitializedException
import pl.arturborowy.logger.tag.TagSettings

class TagSettingsRepository {

    var defaultTagSettings: TagSettings
        get() = defaultTagSettingsInternal ?: throw UltLogNotInitializedException()
        set(value) {
            defaultTagSettingsInternal = value
        }

    private var defaultTagSettingsInternal: TagSettings? = null
}