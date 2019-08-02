package pl.arturborowy.logger

import android.content.Context
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.logger.tag.TagSettings
import pl.arturborowy.logger.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import pl.arturborowy.logger.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import pl.arturborowy.logger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.logger.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

object UltLogInitializer {

    fun initDebug(context: Context,
                  isDebug: Boolean,
                  defaultTagSettings: TagSettings) {
        val applicationContext = context.applicationContext
        ServiceLocatorInitializer.init(applicationContext)

        val defaultClassesToIgnore = listOf(
                UltLog::class,
                StackTraceTagDataProvider::class,
                StringTagProviderWithTagData::class,
                ThrowableTagProviderFromStringTagProvider::class,
                ClassIgnorableStackTraceElementProvider::class
        )

        defaultTagSettings.classesToIgnore.addAll(defaultClassesToIgnore)

        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings

        UltLog.init(isDebug)
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}