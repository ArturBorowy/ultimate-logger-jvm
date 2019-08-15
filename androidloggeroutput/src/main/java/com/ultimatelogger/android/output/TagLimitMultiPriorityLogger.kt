package com.ultimatelogger.android.output

import com.ultimatelogger.android.output.tag.TagCutter
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class TagLimitMultiPriorityLogger(private val multiPriorityLogger: MultiPriorityLogger,
                                           private val tagCutter: TagCutter) :
        MultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.v(getCutTag(tag), msg, throwable)
    }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.d(getCutTag(tag), msg, throwable)
    }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.i(getCutTag(tag), msg, throwable)
    }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.w(getCutTag(tag), msg, throwable)
    }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.e(getCutTag(tag), msg, throwable)
    }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) {
        multiPriorityLogger.wtf(getCutTag(tag), msg, throwable)
    }

    override fun println(priority: Int, tag: String?, msg: String?) {
        multiPriorityLogger.println(priority, getCutTag(tag), msg)
    }

    private fun getCutTag(tag: String?) = tagCutter.toLimit(tag)
}