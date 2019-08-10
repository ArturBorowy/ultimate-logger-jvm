package com.ultimatelogger.multiplatform.output

import com.ultimatelogger.multiplatform.util.runIf

internal class LoggingIfIsOnMultiPriorityLogger(private val logger: MultiPriorityLogger,
                                                override var isLoggingOn: Boolean) :
        SwitchableMultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.v(tag, msg, throwable) }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.d(tag, msg, throwable) }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.i(tag, msg, throwable) }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.w(tag, msg, throwable) }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.e(tag, msg, throwable) }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) =
            runIfIsLogginOn { logger.wtf(tag, msg, throwable) }

    override fun println(priority: Int, tag: String?, msg: String?) =
            runIfIsLogginOn { logger.println(priority, tag, msg) }

    private fun runIfIsLogginOn(block: () -> Unit) = runIf(isLoggingOn) { block() }
}