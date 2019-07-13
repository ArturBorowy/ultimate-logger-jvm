package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.tags.LoggerTag
import pl.arturborowy.logger.di.util.named
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.DebugMultiPriorityLogger
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.dataprovider.*

internal var applicationModule = module {
    single { TagBuilder(get(), get()) }
    single { TagDataConverter() }
    single { TagSettingsRepository() }

    single<StackTraceElementProvider> { ClassIgnorableStackTraceElementProvider(get()) }
    single<TagDataProvider> { StackTraceTagDataProvider(get(), get()) }

    single<MultiPriorityLogger>(named(LoggerTag.DEFAULT)) { AndroidLog() }
    single<MultiPriorityLogger>(named(LoggerTag.DEBUG))
    { (isDebug: Boolean) -> DebugMultiPriorityLogger(get(named(LoggerTag.DEFAULT)), isDebug) }
}