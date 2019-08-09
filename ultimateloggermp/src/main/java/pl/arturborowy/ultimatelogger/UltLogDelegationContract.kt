package pl.arturborowy.ultimatelogger

internal interface UltLogDelegationContract : UltimateLoggerLogMethods {

    fun init(shouldLog: Boolean)
}