package pl.arturborowy.logger

import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.exception.UltLogNotInitializedException
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.TagSettings
import kotlin.reflect.KClass

object UltLog {

    private const val DEFAULT_LOG_MESSAGE = "Empty log"

    private val tagBuilder: TagBuilder
            by LazyServiceLocator.getDependency({ defaultTagSettings }, { classesToIgnore })

    private val logger: MultiPriorityLogger by LazyServiceLocator.getDependency()

    private val defaultTagSettings: TagSettings
        get() = defaultTagSettingsInternal ?: throw UltLogNotInitializedException()

    private val classesToIgnore: Collection<KClass<*>>
        get() = classesToIgnoreInternal ?: throw UltLogNotInitializedException()

    private var defaultTagSettingsInternal: TagSettings? = null
    private var classesToIgnoreInternal: Collection<KClass<*>>? = null

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNr: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null) =
            logger.e(tagBuilder.build(withFileNameAndLineNr, withClassName, withMethodName), msg)

    fun e(throwable: Throwable?, extraMessage: String? = null) =
            logger.e(tagBuilder.buildForThrowable(), extraMessage, throwable)

    fun <AnyT> e(anything: AnyT?,
                 withFileNameAndLineNr: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null) =
            e(anything.toString(), withFileNameAndLineNr, withClassName, withMethodName)

    fun init(defaultTagSettings: TagSettings, classesToIgnore: Collection<KClass<*>>) {
        defaultTagSettingsInternal = defaultTagSettings
        classesToIgnoreInternal = classesToIgnore
    }
}