package com.ultimatelogger.multiplatform.di.tags

internal object LoggerTag {
    private val TAG_PREFIX = this::class.qualifiedName

    val LOGGING_IF_IS_ON = "$TAG_PREFIX LOGGING_IF_IS_ON"
    val DEFAULT = "$TAG_PREFIX DEFAULT"
}