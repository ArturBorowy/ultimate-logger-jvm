package com.ultimatelogger.multiplatform.output

internal interface SwitchableMultiPriorityLogger : MultiPriorityLogger {

    var isLoggingOn: Boolean
}