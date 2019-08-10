package com.ultimatelogger.multiplatform

internal interface UltimateLogger {

    companion object {
        private const val DEFAULT_LOG_MESSAGE = "Empty log"
    }

    fun v(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun v(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> v(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun d(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun d(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> d(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun i(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun i(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> i(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun w(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun w(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> w(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun e(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> e(anything: AnyT?,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun wtf(msg: String? = DEFAULT_LOG_MESSAGE,
            withFileNameAndLineNum: Boolean? = null,
            withClassName: Boolean? = null,
            withMethodName: Boolean? = null)

    fun wtf(throwable: Throwable?, extraMessage: String? = null)

    fun <AnyT> wtf(anything: AnyT?,
                   withFileNameAndLineNum: Boolean? = null,
                   withClassName: Boolean? = null,
                   withMethodName: Boolean? = null)
}