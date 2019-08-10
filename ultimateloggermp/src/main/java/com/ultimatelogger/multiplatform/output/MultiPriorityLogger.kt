package com.ultimatelogger.multiplatform.output

interface MultiPriorityLogger {

    fun v(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun d(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun i(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun w(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun e(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun wtf(tag: String?, msg: String? = null, throwable: Throwable? = null)

    fun println(priority: Int, tag: String?, msg: String?)
}
