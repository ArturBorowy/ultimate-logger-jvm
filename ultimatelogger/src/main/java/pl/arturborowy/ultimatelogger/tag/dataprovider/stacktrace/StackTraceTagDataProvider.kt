package pl.arturborowy.ultimatelogger.tag.dataprovider.stacktrace

import pl.arturborowy.ultimatelogger.tag.dataprovider.TagData
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagDataConverter
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagDataProvider

class StackTraceTagDataProvider(private val stackTraceElementProvider: StackTraceElementProvider,
                                private val tagDataConverter: TagDataConverter) : TagDataProvider {

    override fun getTagData(): TagData? {
        val stackTraceElement = stackTraceElementProvider.getStackTraceElement()
        return stackTraceElement?.let { tagDataConverter.fromStackTraceElement(it) }
    }
}