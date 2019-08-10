package com.ultimatelogger.multiplatform.util

internal fun runIf(condition: Boolean, block: () -> Unit) {
    if (condition) {
        block()
    }
}