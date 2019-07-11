package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.tag.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.TagSettings
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.MultiPriorityLogger

internal var applicationModule = module {
    single { (defaultTagSettings: TagSettings) -> TagBuilder(get(), defaultTagSettings) }
    single { StackTraceElementReceiver() }
    single<MultiPriorityLogger> { AndroidLog() }
}