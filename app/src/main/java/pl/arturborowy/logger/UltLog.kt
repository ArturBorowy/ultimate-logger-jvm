package pl.arturborowy.logger

import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import pl.arturborowy.logger.output.MultiPriorityLogger

object UltLog : KoinComponent {

    private const val DEFAULT_LOG_MESSAGE = "Empty log"

    lateinit var defaultTagSettings: TagSettings

    private val tagBuilder: TagBuilder
            by inject(parameters = { parametersOf(defaultTagSettings) })

    private val logger: MultiPriorityLogger by inject()

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