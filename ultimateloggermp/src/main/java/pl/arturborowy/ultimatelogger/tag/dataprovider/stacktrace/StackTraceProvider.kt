package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

internal interface StackTraceProvider {

    fun provide(): Collection<StackTraceElement>?
}