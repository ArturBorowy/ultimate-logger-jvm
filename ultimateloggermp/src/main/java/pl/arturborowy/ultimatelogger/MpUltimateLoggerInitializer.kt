package pl.arturborowy.ultimatelogger

import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.data.TagSettingsRepository
import pl.arturborowy.ultimatelogger.di.LazyServiceLocator
import pl.arturborowy.ultimatelogger.di.ServiceLocatorInitializer
import pl.arturborowy.ultimatelogger.exception.UltimateLoggerNotInitializedException
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

object MpUltimateLoggerInitializer {

    /**
     * Needed in GenericLoggingExtensions.kt.
     */
    internal val ultimateLogger: SwitchableMultiPriorityUltimateLogger
        get() = ultimateLoggerNullable ?: throw UltimateLoggerNotInitializedException()

    private var ultimateLoggerNullable: SwitchableMultiPriorityUltimateLogger? = null


    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings,
             ultimateLoggerLazy: Lazy<SwitchableMultiPriorityUltimateLogger>,
             logOutput: MultiPriorityLogger) {
        initServiceLocator(logOutput)
        setDefaultTagSettings(defaultTagSettings)

        this.ultimateLoggerNullable = ultimateLoggerLazy.value
        ultimateLoggerLazy.value.init(shouldLog)
    }

    private fun initServiceLocator(logOutput: MultiPriorityLogger) {
        ServiceLocatorInitializer.init(logOutput)
    }

    private fun setDefaultTagSettings(defaultTagSettings: TagSettings) {
        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}