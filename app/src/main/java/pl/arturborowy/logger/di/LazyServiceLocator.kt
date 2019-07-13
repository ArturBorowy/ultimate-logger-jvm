package pl.arturborowy.logger.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import pl.arturborowy.logger.di.util.named

object LazyServiceLocator : KoinComponent {

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            getDependency<DependencyT>(qualifierString, {})

    inline fun <reified DependencyT> getDependency(vararg parametersGetter: () -> Any?) =
            getDependency<DependencyT>(qualifierString = null, parametersGetter = *parametersGetter)

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   vararg parametersGetter: () -> Any? = arrayOf()) =
            inject<DependencyT>(named(qualifierString)) { parametersGetter.toKoinParameters() }

    fun Array<out () -> Any?>.toKoinParameters() =
            parametersOf(*map { it() }.toTypedArray())
}