package pl.arturborowy.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import pl.arturborowy.data.local.Settings
import pl.arturborowy.data.remote.StudioGhibliApi
import pl.arturborowy.injection.ApplicationContext
import pl.arturborowy.injection.module.AppModule
import pl.arturborowy.ui.main.adapter.FilmsAdapter
import pl.arturborowy.util.RetrofitBuilder
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun studioGhibliApi(): StudioGhibliApi

    fun retrofitBuilder(): RetrofitBuilder

    fun settings(): Settings

    fun filmsAdapter(): FilmsAdapter
}
