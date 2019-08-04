package pl.arturborowy.ultimatelogger.tag.provider.string

import pl.arturborowy.ultimatelogger.tag.builder.TagDataTagBuilder
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagDataProvider

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