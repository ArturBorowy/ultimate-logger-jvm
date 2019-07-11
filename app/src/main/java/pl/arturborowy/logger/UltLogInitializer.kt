package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.logger.tag.TagSettings

object UltLogInitializer {

    fun initDebug(context: Context,
                  isDebug: Boolean,
                  loggingSettings: TagSettings) {
        val applicationContext = context.applicationContext
        ServiceLocatorInitializer.init(applicationContext)

        UltLog.defaultTagSettings = loggingSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}