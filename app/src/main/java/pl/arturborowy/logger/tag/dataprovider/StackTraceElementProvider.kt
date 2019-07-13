package pl.arturborowy.logger.tag.dataprovider

interface StackTraceElementProvider {

    fun getStackTraceElement(): StackTraceElement?
}