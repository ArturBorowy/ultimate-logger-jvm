package pl.arturborowy.ultimatelogger.di

import org.koin.dsl.module
import pl.arturborowy.ultimatelogger.DelegatedUltLog
import pl.arturborowy.ultimatelogger.UltLogDelegationContract
import pl.arturborowy.ultimatelogger.data.TagSettingsRepository
import pl.arturborowy.ultimatelogger.di.tags.LoggerTag
import pl.arturborowy.ultimatelogger.di.util.named
import pl.arturborowy.ultimatelogger.output.DebugMultiPriorityLogger
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger
import pl.arturborowy.ultimatelogger.output.SwitchableMultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.builder.TagDataTagBuilder
import pl.arturborowy.ultimatelogger.tag.builder.TagDataTagBuilderWithDefaultSettings
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagDataConverter
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagDataProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.StackTraceElementProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProvider
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProviderWithTagData
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProvider
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

internal fun applicationModule(logOutput: MultiPriorityLogger) = module {
    single<TagDataTagBuilder> { TagDataTagBuilderWithDefaultSettings(get()) }

    single<StringTagProvider> { StringTagProviderWithTagData(get(), get()) }
    single<ThrowableTagProvider> { ThrowableTagProviderFromStringTagProvider(get()) }

    single { TagDataConverter() }
    single { TagSettingsRepository() }

    single<StackTraceElementProvider> { ClassIgnorableStackTraceElementProvider(get()) }
    single<TagDataProvider> { StackTraceTagDataProvider(get(), get()) }

    single(named(LoggerTag.DEFAULT)) { logOutput }
    single<SwitchableMultiPriorityLogger>
    { DebugMultiPriorityLogger(get(named(LoggerTag.DEFAULT)), false) }

    single<UltLogDelegationContract> { DelegatedUltLog(get(), get(), get()) }
}