package pl.arturborowy.ultimatelogger.di.util

fun named(name: String?) = name?.let { org.koin.core.qualifier.named(it) }