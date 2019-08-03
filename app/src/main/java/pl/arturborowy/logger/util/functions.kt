package pl.arturborowy.logger.util

fun runIf(condition: Boolean, block: () -> Unit) {
    if (condition) {
        block()
    }
}