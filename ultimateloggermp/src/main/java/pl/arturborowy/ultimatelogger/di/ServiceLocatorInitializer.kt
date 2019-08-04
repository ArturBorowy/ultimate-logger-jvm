package pl.arturborowy.ultimatelogger.di

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

object ServiceLocatorInitializer {

    fun init(logOutput: MultiPriorityLogger) {
        startKoin {
            printLogger()
            modules(applicationModule(logOutput))
        }
    }

    fun destroy() = stopKoin()
}