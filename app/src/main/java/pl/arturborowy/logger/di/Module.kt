package pl.arturborowy.logger.di

import org.koin.dsl.module
import pl.arturborowy.logger.output.AndroidLog
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.TagSettings
import kotlin.reflect.KClass

internal var applicationModule = module {
    single { (defaultTagSettings: TagSettings, classesToIgnore: Collection<KClass<*>>) ->
        TagBuilder(get(), defaultTagSettings, classesToIgnore)
    }
    single { StackTraceElementReceiver() }
    single<MultiPriorityLogger> { AndroidLog() }
}