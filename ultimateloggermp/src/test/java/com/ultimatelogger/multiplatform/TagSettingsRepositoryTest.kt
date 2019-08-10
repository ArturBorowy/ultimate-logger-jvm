package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.exception.UltimateLoggerNotInitializedException
import com.ultimatelogger.multiplatform.tag.TagSettings
import org.junit.Assert
import org.junit.Test

internal class TagSettingsRepositoryTest {

    private val tagSettingsRepository = TagSettingsRepository()

    @Test(expected = UltimateLoggerNotInitializedException::class)
    fun `defaultTagSettings getter throws exception if defaultTagSettings isn't set`() {
        tagSettingsRepository.defaultTagSettings
    }

    @Test
    fun `defaultTagSettings getter returns value provided by setter`() {
        val givenTagSettings = TagSettings(shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true, shouldLogMethodName = true)

        tagSettingsRepository.defaultTagSettings = givenTagSettings

        Assert.assertEquals(givenTagSettings, tagSettingsRepository.defaultTagSettings)
    }
}