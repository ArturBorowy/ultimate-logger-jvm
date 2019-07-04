package pl.arturborowy.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.arturborowy.injection.ApplicationContext

@Module(includes = [ApiModule::class, LocalDataModule::class, UtilModule::class,
    AdapterModule::class])
class AppModule(private val application: Application) {

    @Provides
    internal fun provideApplication() = application

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context = application
}