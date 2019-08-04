package pl.arturborowy.ultimatelogger.di.util

import org.koin.core.parameter.parametersOf

fun Array<out () -> Any?>.toKoinParameters() =
        parametersOf(*map { it() }.toTypedArray())