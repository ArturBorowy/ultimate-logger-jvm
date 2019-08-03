package pl.arturborowy.logger.tag.provider.string

import pl.arturborowy.logger.tag.builder.TagDataTagBuilder
import pl.arturborowy.logger.tag.dataprovider.TagDataProvider

class StringTagProviderWithTagData(
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