package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.di.LazyServiceLocator

/**
 * Singleton facade for @UltLogDelegationContract.
 */
object UltLog : UltLogDelegationContract {

    private val ultLogDelegationContract: UltLogDelegationContract
            by LazyServiceLocator.getDependency()

    override fun init(shouldLog: Boolean) {
        ultLogDelegationContract.init(shouldLog)
    }

    override fun e(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) =
            ultLogDelegationContract.e(msg, withFileNameAndLineNum, withClassName, withMethodName)

    override fun e(throwable: Throwable?, extraMessage: String?) =
            ultLogDelegationContract.e(throwable, extraMessage)

    override fun <AnyT> e(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) =
            ultLogDelegationContract.e(anything, withFileNameAndLineNum, withClassName, withMethodName)
}