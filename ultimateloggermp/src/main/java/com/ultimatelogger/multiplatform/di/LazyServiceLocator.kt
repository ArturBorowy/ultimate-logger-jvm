package com.ultimatelogger.multiplatform.di

import org.koin.core.KoinComponent
import org.koin.core.inject
import com.ultimatelogger.multiplatform.di.util.named
import com.ultimatelogger.multiplatform.di.util.toKoinParameters

internal object LazyServiceLocator : KoinComponent {

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            getDependency<DependencyT>(qualifierString, {})

    inline fun <reified DependencyT> getDependency(vararg parametersGetter: () -> Any?) =
            getDependency<DependencyT>(qualifierString = null, parametersGetter = *parametersGetter)

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   vararg parametersGetter: () -> Any? = arrayOf()) =
            inject<DependencyT>(named(qualifierString)) { parametersGetter.toKoinParameters() }
}