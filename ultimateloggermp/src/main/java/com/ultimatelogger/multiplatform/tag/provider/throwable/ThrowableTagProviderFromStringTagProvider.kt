package com.ultimatelogger.multiplatform.tag.provider.throwable

import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider

internal class ThrowableTagProviderFromStringTagProvider(
        private val stringTagProvider: StringTagProvider) :
        ThrowableTagProvider {

    override fun provide() =
            stringTagProvider.provide(withFileNameAndLineNum = true,
                    withClassName = false,
                    withMethodName = false)
}