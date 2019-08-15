package com.ultimatelogger.multiplatform.di

import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

internal object ServiceLocatorInitializer {

    fun init(logOutput: MultiPriorityLogger) {
        startKoin {
            printLogger()
            modules(applicationModule(logOutput))
        }
    }

    fun destroy() = stopKoin()
}