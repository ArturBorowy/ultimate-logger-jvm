package pl.arturborowy.ultimatelogger.util

fun runIf(condition: Boolean, block: () -> Unit) {
    if (condition) {
        block()
    }
}