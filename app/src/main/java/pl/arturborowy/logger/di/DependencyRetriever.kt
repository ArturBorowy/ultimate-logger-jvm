package pl.arturborowy.logger.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import pl.arturborowy.logger.di.util.named

object DependencyRetriever : KoinComponent {

    inline fun <reified DependencyT, ParametersT> retrieve(qualifierString: String? = null,
                                                           parameters: ParametersT): Lazy<DependencyT> =
            inject(named(qualifierString)) { parametersOf(parameters) }
}