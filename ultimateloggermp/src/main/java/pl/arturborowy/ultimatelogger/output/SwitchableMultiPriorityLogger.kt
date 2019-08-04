package pl.arturborowy.ultimatelogger.output

internal interface SwitchableMultiPriorityLogger : MultiPriorityLogger {

    var isLoggingOn: Boolean
}