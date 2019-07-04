package pl.arturborowy.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.arturborowy.data.local.Settings
import javax.inject.Singleton

@Module
class LocalDataModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideSettings() = Settings(context)
}