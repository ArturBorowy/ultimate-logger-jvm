package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.di.LazyServiceLocator
import pl.arturborowy.ultimatelogger.di.tags.LoggerTag
import pl.arturborowy.ultimatelogger.exception.UltLogNotInitializedException
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProvider
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProvider

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
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null) =
            logger.e(
                    stringTagProvider.provide(withFileNameAndLineNum,
                            withClassName,
                            withMethodName),
                    msg)

    fun e(throwable: Throwable?, extraMessage: String? = null) =
            logger.e(throwableTagProvider.provide(), extraMessage, throwable)

    fun <AnyT> e(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null) =
            e(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)

    internal fun init(isDebug: Boolean) {
        isDebugInternal = isDebug
    }
}