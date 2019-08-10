package com.ultimatelogger.multiplatform

import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import com.ultimatelogger.multiplatform.util.CryptoNullable

class CryptoNullableTest {

    private val givenThrowable : Throwable = mock()

    private var cryptoNullable : Any by CryptoNullable(givenThrowable)

    @Test(expected = Throwable::class)
    fun `getter throws givenThrowable if setter wasn't called before`() {
        cryptoNullable
    }

    @Test
    fun `getter doesn't throw givenThrowable if setter was called before`() {
        val givenValue = Any()

        cryptoNullable = givenValue
        cryptoNullable
    }

    @Test
    fun `getter returns value set by setter`() {
        val givenValue = Any()

        cryptoNullable = givenValue

        Assert.assertEquals(givenValue, cryptoNullable)
    }
}