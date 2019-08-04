package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

internal interface StackTraceElementProvider {

    fun getStackTraceElement(): StackTraceElement?
}