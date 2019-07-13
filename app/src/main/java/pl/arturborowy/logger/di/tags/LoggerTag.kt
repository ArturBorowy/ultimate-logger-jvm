package pl.arturborowy.logger.di.tags

object LoggerTag {
    private val TAG = this::class.qualifiedName

    val DEBUG = "$TAG debug"
    val DEFAULT = "$TAG default"
}