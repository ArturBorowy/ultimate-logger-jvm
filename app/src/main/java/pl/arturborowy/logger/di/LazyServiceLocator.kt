package pl.arturborowy.logger.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import pl.arturborowy.logger.di.util.named

object LazyServiceLocator : KoinComponent {

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            inject<DependencyT>(named(qualifierString))

    inline fun <reified DependencyT> getDependency(vararg parametersGetter: () -> Any?) =
            inject<DependencyT> { parametersGetter.toKoinParameters() }

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   vararg parametersGetter: () -> Any? = arrayOf()) =
            inject<DependencyT>(named(qualifierString)) { parametersGetter.toKoinParameters() }

    fun Array<out () -> Any?>.toKoinParameters() =
            parametersOf(*map { it() }.toTypedArray())
}