package pl.arturborowy.injection.module

import dagger.Module
import dagger.Provides
import pl.arturborowy.util.RetrofitBuilder
import pl.arturborowy.util.ViewInflater
import javax.inject.Singleton

@Module
class UtilModule {

    @Provides
    @Singleton
    internal fun provideRetrofitBuilder() = RetrofitBuilder()

    @Provides
    internal fun prodvideViewInflater() = ViewInflater()
}