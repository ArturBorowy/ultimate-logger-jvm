package pl.arturborowy.ultimatelogger.di.tags

internal object LoggerTag {
    private val TAG_PREFIX = this::class.qualifiedName

    val DEBUG = "$TAG_PREFIX debug"
    val DEFAULT = "$TAG_PREFIX default"
}