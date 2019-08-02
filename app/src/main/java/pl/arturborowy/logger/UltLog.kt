package pl.arturborowy.logger

import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.di.tags.LoggerTag
import pl.arturborowy.logger.exception.UltLogNotInitializedException
import pl.arturborowy.logger.output.MultiPriorityLogger
import pl.arturborowy.logger.tag.provider.string.StringTagProvider
import pl.arturborowy.logger.tag.provider.throwable.ThrowableTagProvider

object UltLog {

    private const val DEFAULT_LOG_MESSAGE = "Empty log"

    private val stringTagProvider: StringTagProvider by LazyServiceLocator.getDependency()

    private val throwableTagProvider: ThrowableTagProvider by LazyServiceLocator.getDependency()

    private val logger: MultiPriorityLogger
            by LazyServiceLocator.getDependency(LoggerTag.DEBUG, { isDebug })

    private val isDebug: Boolean
        get() = isDebugInternal ?: throw UltLogNotInitializedException()

    private var isDebugInternal: Boolean? = null

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNr: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null) =
            logger.e(
                    stringTagProvider.provide(withFileNameAndLineNr,
                            withClassName,
                            withMethodName),
                    msg)

    fun e(throwable: Throwable?, extraMessage: String? = null) =
            logger.e(throwableTagProvider.provide(), extraMessage, throwable)

    fun <AnyT> e(anything: AnyT?,
                 withFileNameAndLineNr: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null) =
            e(anything.toString(), withFileNameAndLineNr, withClassName, withMethodName)

    fun init(isDebug: Boolean) {
        this.isDebugInternal = isDebug
    }
}