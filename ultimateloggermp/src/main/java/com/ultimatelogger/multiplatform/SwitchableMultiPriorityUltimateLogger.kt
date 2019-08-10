package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.output.SwitchableMultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProvider

abstract class SwitchableMultiPriorityUltimateLogger : InitializableUltimateLogger {

    private val logger: SwitchableMultiPriorityLogger by LazyServiceLocator.getDependency()
    private val stringTagProvider: StringTagProvider by LazyServiceLocator.getDependency()
    private val throwableTagProvider: ThrowableTagProvider by LazyServiceLocator.getDependency()

    override fun init(shouldLog: Boolean) {
        logger.isLoggingOn = shouldLog
    }

    override fun v(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.v(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun v(throwable: Throwable?,
                   extraMessage: String?) {
        logger.v(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> v(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        v(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun d(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.d(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun d(throwable: Throwable?,
                   extraMessage: String?) {
        logger.d(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> d(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        d(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun i(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.i(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun i(throwable: Throwable?,
                   extraMessage: String?) {
        logger.i(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> i(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        i(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun w(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.w(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun w(throwable: Throwable?,
                   extraMessage: String?) {
        logger.w(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> w(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        w(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun e(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.e(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun e(throwable: Throwable?,
                   extraMessage: String?) {
        logger.e(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> e(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        e(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun wtf(msg: String?,
                     withFileNameAndLineNum: Boolean?,
                     withClassName: Boolean?,
                     withMethodName: Boolean?) {
        logger.wtf(
                getTagForString(withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun wtf(throwable: Throwable?,
                     extraMessage: String?) {
        logger.wtf(getTagForThrowable(), extraMessage, throwable)
    }

    override fun <AnyT> wtf(anything: AnyT?,
                            withFileNameAndLineNum: Boolean?,
                            withClassName: Boolean?,
                            withMethodName: Boolean?) {
        wtf(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)
    }

    private fun getTagForString(withFileNameAndLineNum: Boolean?,
                                withClassName: Boolean?,
                                withMethodName: Boolean?) =
            stringTagProvider.provide(withFileNameAndLineNum,
                    withClassName,
                    withMethodName)

    private fun getTagForThrowable() = throwableTagProvider.provide()
}