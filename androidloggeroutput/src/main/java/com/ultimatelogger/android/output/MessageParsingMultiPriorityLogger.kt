package com.ultimatelogger.android.output

import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class MessageParsingMultiPriorityLogger(
        private val multiPriorityLogger: MultiPriorityLogger,
        private val messageForThrowableLogParser: MessageForThrowableLogParser) :
        MultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.v(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.d(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.i(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.w(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.e(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.wtf(tag, getParsedMsg(msg, throwable), throwable)
    }

    override fun println(priority: Int, tag: String?, msg: String?) {
        multiPriorityLogger.println(priority, tag, msg)
    }

    private fun getParsedMsg(msg: String?, throwable: Throwable?) =
            messageForThrowableLogParser.getMsg(msg, throwable)
}