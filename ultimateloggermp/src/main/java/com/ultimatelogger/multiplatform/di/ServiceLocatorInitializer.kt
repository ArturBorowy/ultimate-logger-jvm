package com.ultimatelogger.multiplatform.di

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal object ServiceLocatorInitializer {

    fun init(logOutput: MultiPriorityLogger) {
        startKoin {
            printLogger()
            modules(applicationModule(logOutput))
        }
    }

    fun destroy() = stopKoin()
}