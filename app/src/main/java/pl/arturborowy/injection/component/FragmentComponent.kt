package pl.arturborowy.injection.component

import dagger.Subcomponent
import pl.arturborowy.injection.PerFragment
import pl.arturborowy.injection.module.FragmentModule

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent