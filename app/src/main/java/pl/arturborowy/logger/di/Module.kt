package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.tags.LoggerTag
import pl.arturborowy.logger.di.util.named
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.DebugMultiPriorityLogger
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.dataprovider.StackTraceTagDataProvider
import pl.arturborowy.logger.tag.TagBuilder

internal var applicationModule = module {
    single { TagBuilder(get(), get()) }
    single { StackTraceTagDataProvider(get()) }

    single<MultiPriorityLogger>(named(LoggerTag.DEFAULT)) { AndroidLog() }
    single<MultiPriorityLogger>(named(LoggerTag.DEBUG))
    { (isDebug: Boolean) -> DebugMultiPriorityLogger(get(named(LoggerTag.DEFAULT)), isDebug) }

    single { TagSettingsRepository() }
}