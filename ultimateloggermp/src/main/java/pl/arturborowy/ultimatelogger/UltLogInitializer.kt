package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.data.TagSettingsRepository
import pl.arturborowy.ultimatelogger.di.LazyServiceLocator
import pl.arturborowy.ultimatelogger.di.ServiceLocatorInitializer
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.TagSettings
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

object UltLogInitializer {

    fun initDebug(isDebug: Boolean,
                  defaultTagSettings: TagSettings,
                  ultLog: UltLog,
                  logOutput: MultiPriorityLogger) {
        initServiceLocator(logOutput)
        setDefaultTagSettings(defaultTagSettings)
        ultLog.init(isDebug)
    }

    private fun initServiceLocator(logOutput: MultiPriorityLogger) {
        ServiceLocatorInitializer.init(logOutput)
    }

    private fun setDefaultTagSettings(defaultTagSettings: TagSettings) {
        val defaultClassesToIgnore = listOf(
                UltLog::class,
                StackTraceTagDataProvider::class,
                StringTagProviderWithTagData::class,
                DelegatedUltLog::class,
                UltimateLoggerLogMethods::class,
                ThrowableTagProviderFromStringTagProvider::class,
                ClassIgnorableStackTraceElementProvider::class
        )

        defaultTagSettings.classesToIgnore.addAll(defaultClassesToIgnore)

        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}