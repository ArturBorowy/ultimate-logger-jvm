package pl.arturborowy.logger

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

object UltLog : KoinComponent {

    private const val DEFAULT_LOG_MESSAGE = "Empty log"

    lateinit var defaultTagSettings: TagSettings

    private val tagBuilder: TagBuilder
            by inject(parameters = { parametersOf(defaultTagSettings) })

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNme: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null,
          withLineNumber: Boolean? = null) {
        Log.e(tagBuilder.build(withFileNme,
                withClassName,
                withMethodName,
                withLineNumber), msg)
    }

    fun e(throwable: Throwable?,
          extraMessage: String? = null) {
        Log.e(tagBuilder.buildForThrowable(), extraMessage, throwable)
    }

    fun <AnyT> e(anything: AnyT?,
                 withFileNme: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null,
                 withLineNumber: Boolean? = null) =
            e(anything.toString(), withFileNme, withClassName, withMethodName, withLineNumber)
}