package pl.arturborowy.logger.tag.provider.throwable

import pl.arturborowy.logger.tag.provider.string.StringTagProvider

class ThrowableTagProviderFromStringTagProvider(private val stringTagProvider: StringTagProvider) :
        ThrowableTagProvider {

    override fun provide() =
            stringTagProvider.provide(withFileNameAndLineNr = true,
                    withClassName = false,
                    withMethodName = false)
}