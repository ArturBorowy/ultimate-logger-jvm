package pl.arturborowy.logger.tag.dataprovider

class StackTraceTagDataProvider(private val stackTraceElementProvider: StackTraceElementProvider,
                                private val tagDataConverter: TagDataConverter) : TagDataProvider {

    override fun getTagData(): TagData? {
        val stackTraceElement = stackTraceElementProvider.getStackTraceElement()
        return stackTraceElement?.let { tagDataConverter.fromStackTraceElement(it) }
    }
}