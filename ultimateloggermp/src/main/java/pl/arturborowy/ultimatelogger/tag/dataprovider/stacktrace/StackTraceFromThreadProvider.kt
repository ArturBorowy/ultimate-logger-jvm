package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

internal class StackTraceFromThreadProvider : StackTraceProvider {

    override fun provide(): Collection<StackTraceElement>? {
        return Thread.currentThread()?.stackTrace?.toList()
    }
}