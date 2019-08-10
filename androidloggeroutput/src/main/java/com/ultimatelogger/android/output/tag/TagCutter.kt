package com.ultimatelogger.android.output.tag

internal interface TagCutter {

    fun toLimit(tag: String?): String?
}