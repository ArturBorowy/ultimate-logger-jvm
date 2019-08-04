package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.output.SwitchableMultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProvider
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProvider

internal class DelegatedUltLog(private val logger: SwitchableMultiPriorityLogger,
                               private val stringTagProvider: StringTagProvider,
                               private val throwableTagProvider: ThrowableTagProvider)
    : UltLogDelegationContract {

    override fun e(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) =
            logger.e(
                    stringTagProvider.provide(withFileNameAndLineNum,
                            withClassName,
                            withMethodName),
                    msg)

    override fun e(throwable: Throwable?, extraMessage: String?) =
            logger.e(throwableTagProvider.provide(), extraMessage, throwable)

    override fun <AnyT> e(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) =
            e(anything.toString(), withFileNameAndLineNum, withClassName, withMethodName)

    override fun init(shouldLog: Boolean) {
        logger.isLoggingOn = shouldLog
    }
}