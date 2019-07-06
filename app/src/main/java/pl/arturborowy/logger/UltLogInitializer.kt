package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.di.ServiceLocatorInitializer

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