package pl.arturborowy.logger

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

object UltLog : KoinComponent {

    lateinit var defaultTagSettings: TagSettings

    private val tagBuilder: TagBuilder
            by inject(parameters = { parametersOf(defaultTagSettings) })

    fun e(msg: String,
          withFileNme: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null,
          withLineNumber: Boolean? = null) =
            Log.e(tagBuilder.build(withFileNme,
                    withClassName,
                    withMethodName,
                    withLineNumber), msg)

}