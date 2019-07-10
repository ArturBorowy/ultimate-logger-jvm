package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.StackTraceElementReceiver
import pl.arturborowy.logger.TagBuilder
import pl.arturborowy.logger.TagSettings
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.MultiPriorityLogger

internal var applicationModule = module {
    single { (defaultTagSettings: TagSettings) -> TagBuilder(get(), defaultTagSettings) }
    single { StackTraceElementReceiver() }
    single<MultiPriorityLogger> { AndroidLog() }
}