package pl.arturborowy.ultimatelogger

internal interface UltimateLoggerLogMethods {

    companion object {
        private const val DEFAULT_LOG_MESSAGE = "Empty log"
    }

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun e(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> e(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)
}