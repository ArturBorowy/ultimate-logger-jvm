package com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace

internal class StackTraceFromThreadProvider : StackTraceProvider {

    override fun provide(): Collection<StackTraceElement>? {
        return Thread.currentThread()?.stackTrace?.toList()
    }
}