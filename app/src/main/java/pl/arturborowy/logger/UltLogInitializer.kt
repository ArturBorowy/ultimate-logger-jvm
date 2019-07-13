package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.logger.tag.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagSettings

object UltLogInitializer {

    fun initDebug(context: Context,
                  isDebug: Boolean,
                  defaultTagSettings: TagSettings) {
        val applicationContext = context.applicationContext
        ServiceLocatorInitializer.init(applicationContext)

        val defaultClassesToIgnore = listOf(
                UltLog::class,
                StackTraceElementReceiver::class
        )

        defaultTagSettings.classesToIgnore.addAll(defaultClassesToIgnore)

        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}