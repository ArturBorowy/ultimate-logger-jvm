package pl.arturborowy.logger.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import pl.arturborowy.logger.di.util.named

object LazyServiceLocator : KoinComponent {

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            inject<DependencyT>(named(qualifierString))

    inline fun <reified DependencyT> getDependency(crossinline parametersGetter: () -> Any?) =
            inject<DependencyT> { parametersOf(parametersGetter()) }

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   crossinline parametersGetter: () -> Any? = { null }) =
            inject<DependencyT>(named(qualifierString)) { parametersOf(parametersGetter()) }
}