package com.ultimatelogger.multiplatform.di.util

import org.koin.core.parameter.parametersOf

internal fun Array<out () -> Any?>.toKoinParameters() =
        parametersOf(*map { it() }.toTypedArray())