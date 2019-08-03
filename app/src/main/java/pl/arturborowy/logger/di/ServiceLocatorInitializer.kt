package pl.arturborowy.logger.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

object ServiceLocatorInitializer {

    fun init(applicationContext: Context) {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }

    fun destroy() = stopKoin()
}