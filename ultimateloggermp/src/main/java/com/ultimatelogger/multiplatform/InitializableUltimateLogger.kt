package com.ultimatelogger.multiplatform

internal interface InitializableUltimateLogger : UltimateLogger {

    fun init(shouldLog: Boolean)
}