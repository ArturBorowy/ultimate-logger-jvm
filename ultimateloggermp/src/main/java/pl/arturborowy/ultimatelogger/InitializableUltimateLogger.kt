package pl.arturborowy.ultimatelogger

internal interface InitializableUltimateLogger : UltimateLogger {

    fun init(shouldLog: Boolean)
}