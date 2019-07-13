package pl.arturborowy.logger.tag.dataprovider.stacktrace

import pl.arturborowy.logger.tag.dataprovider.TagData
import pl.arturborowy.logger.tag.dataprovider.TagDataConverter
import pl.arturborowy.logger.tag.dataprovider.TagDataProvider

class StackTraceTagDataProvider(private val stackTraceElementProvider: StackTraceElementProvider,
                                private val tagDataConverter: TagDataConverter) : TagDataProvider {

    override fun getTagData(): TagData? {
        val stackTraceElement = stackTraceElementProvider.getStackTraceElement()
        return stackTraceElement?.let { tagDataConverter.fromStackTraceElement(it) }
    }
}