package pl.arturborowy.injection.module

import android.app.Activity
import android.content.Context

import dagger.Module
import dagger.Provides
import pl.arturborowy.injection.ActivityContext

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    internal fun provideActivity() = activity

    @Provides
    @ActivityContext
    internal fun providesContext(): Context = activity
}
