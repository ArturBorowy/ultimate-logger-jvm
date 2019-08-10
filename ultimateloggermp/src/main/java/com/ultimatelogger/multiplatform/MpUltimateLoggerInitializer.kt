package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.di.ServiceLocatorInitializer
import com.ultimatelogger.multiplatform.exception.UltimateLoggerNotInitializedException
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.util.CryptoNullable

object MpUltimateLoggerInitializer {

    /**
     * Needed in GenericLoggingExtensions.kt.
     */
    internal var ultimateLogger: SwitchableMultiPriorityUltimateLogger
            by CryptoNullable(UltimateLoggerNotInitializedException())

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings,
             ultimateLoggerLazy: Lazy<SwitchableMultiPriorityUltimateLogger>,
             logOutput: MultiPriorityLogger) {
        initServiceLocator(logOutput)
        setDefaultTagSettings(defaultTagSettings)

        ultimateLogger = ultimateLoggerLazy.value
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