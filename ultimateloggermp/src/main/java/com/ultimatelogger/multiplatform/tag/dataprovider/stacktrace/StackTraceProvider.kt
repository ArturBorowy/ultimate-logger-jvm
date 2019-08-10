package com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace

internal interface StackTraceProvider {

    fun provide(): Collection<StackTraceElement>?
}