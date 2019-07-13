package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagBuilder

internal var applicationModule = module {
    single { TagBuilder(get(), get()) }
    single { StackTraceElementReceiver(get()) }
    single<MultiPriorityLogger> { AndroidLog() }
    single { TagSettingsRepository() }
}