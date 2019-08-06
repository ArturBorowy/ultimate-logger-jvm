package pl.arturborowy.ultimatelogger

import pl.arturborowy.ultimatelogger.di.LazyServiceLocator

/**
 * Singleton facade for @UltLogDelegationContract.
 */
abstract class UltLog : UltLogDelegationContract {

    private val ultLogDelegationContract: UltLogDelegationContract
            by LazyServiceLocator.getDependency()

    override fun init(shouldLog: Boolean) {
        ultLogDelegationContract.init(shouldLog)
    }

    override fun v(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        ultLogDelegationContract.v(msg, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun v(throwable: Throwable?,
                   extraMessage: String?) {
        ultLogDelegationContract.v(throwable, extraMessage)
    }

    override fun <AnyT> v(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        ultLogDelegationContract.v(anything, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun d(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        ultLogDelegationContract.d(msg, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun d(throwable: Throwable?,
                   extraMessage: String?) {
        ultLogDelegationContract.d(throwable, extraMessage)
    }

    override fun <AnyT> d(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        ultLogDelegationContract.d(anything, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun i(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        ultLogDelegationContract.i(msg, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun i(throwable: Throwable?,
                   extraMessage: String?) {
        ultLogDelegationContract.i(throwable, extraMessage)
    }

    override fun <AnyT> i(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        ultLogDelegationContract.i(anything, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun w(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        ultLogDelegationContract.w(msg, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun w(throwable: Throwable?, extraMessage: String?) {
        ultLogDelegationContract.w(throwable, extraMessage)
    }

    override fun <AnyT> w(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        ultLogDelegationContract.w(anything, withFileNameAndLineNum, withClassName, withMethodName)
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

    override fun wtf(msg: String?,
                     withFileNameAndLineNum: Boolean?,
                     withClassName: Boolean?,
                     withMethodName: Boolean?) {
        ultLogDelegationContract.wtf(msg, withFileNameAndLineNum, withClassName, withMethodName)
    }

    override fun wtf(throwable: Throwable?,
                     extraMessage: String?) {
        ultLogDelegationContract.wtf(throwable, extraMessage)
    }

    override fun <AnyT> wtf(anything: AnyT?,
                            withFileNameAndLineNum: Boolean?,
                            withClassName: Boolean?,
                            withMethodName: Boolean?) {
        ultLogDelegationContract.wtf(anything, withFileNameAndLineNum, withClassName, withMethodName)
    }
}