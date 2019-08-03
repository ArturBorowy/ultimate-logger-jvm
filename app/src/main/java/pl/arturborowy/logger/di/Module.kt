package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.di.tags.LoggerTag
import pl.arturborowy.logger.di.util.named
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.DebugMultiPriorityLogger
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.builder.TagDataTagBuilder
import pl.arturborowy.logger.tag.builder.TagDataTagBuilderWithDefaultSettings
import pl.arturborowy.logger.tag.dataprovider.TagDataConverter
import pl.arturborowy.logger.tag.dataprovider.TagDataProvider
import pl.arturborowy.logger.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import pl.arturborowy.logger.tag.dataprovider.stacktrace.StackTraceElementProvider
import pl.arturborowy.logger.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import pl.arturborowy.logger.tag.provider.string.StringTagProvider
import pl.arturborowy.logger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.logger.tag.provider.throwable.ThrowableTagProvider
import pl.arturborowy.logger.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

internal var applicationModule = module {
    single<TagDataTagBuilder> { TagDataTagBuilderWithDefaultSettings(get()) }

    single<StringTagProvider> { StringTagProviderWithTagData(get(), get()) }
    single<ThrowableTagProvider> { ThrowableTagProviderFromStringTagProvider(get()) }

    single { TagDataConverter() }
    single { TagSettingsRepository() }

    single<StackTraceElementProvider> { ClassIgnorableStackTraceElementProvider(get()) }
    single<TagDataProvider> { StackTraceTagDataProvider(get(), get()) }

    single<MultiPriorityLogger>(named(LoggerTag.DEFAULT)) { AndroidLog() }
    single<MultiPriorityLogger>(named(LoggerTag.DEBUG))
    { (isDebug: Boolean) -> DebugMultiPriorityLogger(get(named(LoggerTag.DEFAULT)), isDebug) }
}