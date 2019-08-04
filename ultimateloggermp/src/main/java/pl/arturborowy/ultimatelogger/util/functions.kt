package pl.arturborowy.ultimatelogger.util

internal fun runIf(condition: Boolean, block: () -> Unit) {
    if (condition) {
        block()
    }
}