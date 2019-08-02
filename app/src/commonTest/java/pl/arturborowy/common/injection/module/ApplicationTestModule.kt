package pl.arturborowy.common.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import pl.arturborowy.data.local.Settings
import pl.arturborowy.data.remote.StudioGhibliApi
import pl.arturborowy.injection.ApplicationContext
import pl.arturborowy.util.RetrofitBuilder
import javax.inject.Singleton

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
class ApplicationTestModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication() = application

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context = application

    /*************
     * MOCKS
     */

    @Provides
    @Singleton
    internal fun provideStudioGhibliApi(): StudioGhibliApi = mock(StudioGhibliApi::class.java)

    @Provides
    @Singleton
    internal fun provideRetrofitBuilder(): RetrofitBuilder = mock(RetrofitBuilder::class.java)

    @Provides
    @Singleton
    fun provideSettings(): Settings = mock(Settings::class.java)
}
