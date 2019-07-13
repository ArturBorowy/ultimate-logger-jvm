package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.logger.tag.dataprovider.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.TagSettings

object UltLogInitializer {

    fun initDebug(context: Context,
                  isDebug: Boolean,
                  defaultTagSettings: TagSettings) {
        val applicationContext = context.applicationContext
        ServiceLocatorInitializer.init(applicationContext)

        val defaultClassesToIgnore = listOf(
                UltLog::class,
                StackTraceElementReceiver::class,
                TagBuilder::class
        )

        defaultTagSettings.classesToIgnore.addAll(defaultClassesToIgnore)

        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings

        UltLog.init(isDebug)
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}