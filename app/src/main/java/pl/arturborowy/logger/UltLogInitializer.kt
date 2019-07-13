package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.logger.tag.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagSettings

object UltLogInitializer {

    fun initDebug(context: Context,
                  isDebug: Boolean,
                  defaultTagSettings: TagSettings) {
        val applicationContext = context.applicationContext
        ServiceLocatorInitializer.init(applicationContext)

        val classesToIgnore = listOf(
                UltLog::class,
                StackTraceElementReceiver::class
        )
        UltLog.init(defaultTagSettings, classesToIgnore)
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}