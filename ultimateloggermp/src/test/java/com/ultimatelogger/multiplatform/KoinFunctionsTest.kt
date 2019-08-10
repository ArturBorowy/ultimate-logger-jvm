package com.ultimatelogger.multiplatform

import org.junit.Assert
import org.junit.Test
import org.koin.core.qualifier.StringQualifier
import com.ultimatelogger.multiplatform.di.util.named

internal class KoinFunctionsTest {

    @Test
    fun `named(String?) behaves as koin's named(String) if given name is not null`() {
        val givenName = "][;];][;][]["

        Assert.assertEquals(StringQualifier(givenName), named(givenName))
    }

    @Test
    fun `named(String?) returns null if give name is null`() {
        val givenName = null

        Assert.assertEquals(null, named(givenName))
    }
}