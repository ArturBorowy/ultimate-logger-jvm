package pl.arturborowy.ultimatelogger.output

import pl.arturborowy.ultimatelogger.util.runIf

class DebugMultiPriorityLogger(private val logger: MultiPriorityLogger,
                               private val isDebug: Boolean) : MultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.v(tag, msg, throwable) }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.d(tag, msg, throwable) }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.i(tag, msg, throwable) }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.w(tag, msg, throwable) }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.e(tag, msg, throwable) }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) =
            runIfDebug { logger.wtf(tag, msg, throwable) }

    override fun println(priority: Int, tag: String?, msg: String?) =
            runIfDebug { logger.println(priority, tag, msg) }

    private fun runIfDebug(block: () -> Unit) = runIf(isDebug) { block() }
}