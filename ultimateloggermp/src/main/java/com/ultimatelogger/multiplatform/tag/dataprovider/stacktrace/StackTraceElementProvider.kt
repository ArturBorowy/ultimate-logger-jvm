package com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace

internal interface StackTraceElementProvider {

    fun getStackTraceElement(): StackTraceElement?
}