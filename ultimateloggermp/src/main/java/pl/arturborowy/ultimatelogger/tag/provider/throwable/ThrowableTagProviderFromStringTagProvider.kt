package pl.arturborowy.ultimatelogger.tag.provider.throwable

import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProvider

class ThrowableTagProviderFromStringTagProvider(private val stringTagProvider: StringTagProvider) :
        ThrowableTagProvider {

    override fun provide() =
            stringTagProvider.provide(withFileNameAndLineNum = true,
                    withClassName = false,
                    withMethodName = false)
}