package pl.arturborowy.common.injection.component

import dagger.Component
import pl.arturborowy.common.injection.module.ApplicationTestModule
import pl.arturborowy.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationTestModule::class])
interface TestComponent : AppComponent