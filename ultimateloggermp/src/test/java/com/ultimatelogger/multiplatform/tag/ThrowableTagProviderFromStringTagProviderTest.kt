package com.ultimatelogger.multiplatform.tag

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

internal class ThrowableTagProviderFromStringTagProviderTest {

    private val mockStringTagProvider: StringTagProvider = mock()

    private val throwableTagProviderFromStringTagProvider =
            ThrowableTagProviderFromStringTagProvider(mockStringTagProvider)

    @Test
    fun `provide() returns tag from stringTagProvider provide(true, false, false)`() {
        val givenTag = "okpwro23[ik[2"

        given(mockStringTagProvider
                .provide(withFileNameAndLineNum = true,
                        withClassName = false,
                        withMethodName = false))
                .willReturn(givenTag)

        Assert.assertEquals(givenTag, throwableTagProviderFromStringTagProvider.provide())
    }
}