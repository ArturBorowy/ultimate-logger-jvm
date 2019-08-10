package com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace

import com.ultimatelogger.multiplatform.tag.dataprovider.TagData
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataConverter
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataProvider

internal class StackTraceTagDataProvider(
        private val stackTraceElementProvider: StackTraceElementProvider,
        private val tagDataConverter: TagDataConverter) : TagDataProvider {

    override fun getTagData(): TagData? {
        val stackTraceElement = stackTraceElementProvider.getStackTraceElement()
        return stackTraceElement?.let { tagDataConverter.fromStackTraceElement(it) }
    }
}