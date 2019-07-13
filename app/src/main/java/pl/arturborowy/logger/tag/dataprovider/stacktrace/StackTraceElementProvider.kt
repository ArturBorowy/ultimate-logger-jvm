package pl.arturborowy.logger.tag.dataprovider.stacktrace

interface StackTraceElementProvider {

    fun getStackTraceElement(): StackTraceElement?
}