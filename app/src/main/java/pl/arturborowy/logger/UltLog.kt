package pl.arturborowy.logger

import pl.arturborowy.logger.di.LazyServiceLocator
import pl.arturborowy.logger.output.MultiPriorityLogger

object UltLog {

    private const val DEFAULT_LOG_MESSAGE = "Empty log"

    lateinit var defaultTagSettings: TagSettings

    private val tagBuilder: TagBuilder by LazyServiceLocator.getDependency { defaultTagSettings }

    private val logger: MultiPriorityLogger by LazyServiceLocator.getDependency()

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
}