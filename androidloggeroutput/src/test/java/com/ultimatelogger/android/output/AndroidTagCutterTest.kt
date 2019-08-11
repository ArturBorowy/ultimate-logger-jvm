package com.ultimatelogger.android.output

import com.ultimatelogger.android.output.tag.AndroidTagCutter
import org.junit.Assert
import org.junit.Test

internal class AndroidTagCutterTest {

    @Test
    fun `toLimit() returns givenTag if is shorter than limit`() {
        val givenApiVersion = 1
        val androidTagCutter = AndroidTagCutter(givenApiVersion)
        val givenTag = "1234"

        Assert.assertEquals(givenTag, androidTagCutter.toLimit(givenTag))
    }

    @Test
    fun `toLimit() returns givenTag if is longer than limit and api is higher then 23`() {
        val givenApiVersion = 26
        val androidTagCutter = AndroidTagCutter(givenApiVersion)
        val givenTag = "123456789012345678901234567890"

        Assert.assertEquals(givenTag, androidTagCutter.toLimit(givenTag))
    }

    @Test
    fun `toLimit() returns cut tag if is longer than limit but api is lower then 23`() {
        val givenApiVersion = 1
        val androidTagCutter = AndroidTagCutter(givenApiVersion)
        val givenTag = "123456789012345678901234567890"

        Assert.assertEquals("12345678901234567890123",
                androidTagCutter.toLimit(givenTag))
    }
}