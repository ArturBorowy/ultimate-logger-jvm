package pl.arturborowy.logger.di.util

import org.koin.core.qualifier.StringQualifier

fun named(name: String?) = name?.let { StringQualifier(it) }