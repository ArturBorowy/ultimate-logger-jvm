package pl.arturborowy.ultimatelogger

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.data.TagSettingsRepository
import pl.arturborowy.ultimatelogger.di.LazyServiceLocator
import pl.arturborowy.ultimatelogger.di.ServiceLocatorInitializer
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

object MpUltimateLoggerInitializer {

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings,
             ultimateLogger: Lazy<SwitchableMultiPriorityUltimateLogger>,
             logOutput: MultiPriorityLogger) {
        initServiceLocator(logOutput)
        setDefaultTagSettings(defaultTagSettings)
        ultimateLogger.value.init(shouldLog)
    }

    private fun initServiceLocator(logOutput: MultiPriorityLogger) {
        ServiceLocatorInitializer.init(logOutput)
    }

    private fun setDefaultTagSettings(defaultTagSettings: TagSettings) {
        val defaultClassesToIgnore = listOf(
                StackTraceTagDataProvider::class,
                StringTagProviderWithTagData::class,
                SwitchableMultiPriorityUltimateLogger::class,
                UltimateLogger::class,
                ThrowableTagProviderFromStringTagProvider::class,
                ClassIgnorableStackTraceElementProvider::class
        )

        defaultTagSettings.classesToIgnore.addAll(defaultClassesToIgnore)

        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}