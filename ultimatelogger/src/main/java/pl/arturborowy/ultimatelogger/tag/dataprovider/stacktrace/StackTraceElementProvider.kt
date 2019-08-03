package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

interface StackTraceElementProvider {

    fun getStackTraceElement(): StackTraceElement?
}