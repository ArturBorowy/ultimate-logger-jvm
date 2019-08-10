package com.ultimatelogger.multiplatform.tag.provider.string

import com.ultimatelogger.multiplatform.tag.builder.TagDataTagBuilder
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataProvider

internal class StringTagProviderWithTagData(
        private val tagDataProvider: TagDataProvider,
        private val tagDataTagBuilder: TagDataTagBuilder)
    : StringTagProvider {

    override fun provide(withFileNameAndLineNum: Boolean?,
                         withClassName: Boolean?,
                         withMethodName: Boolean?): String {
        val tagData = tagDataProvider.getTagData()
        return tagDataTagBuilder
                .build(tagData, withFileNameAndLineNum, withClassName, withMethodName)
    }
}