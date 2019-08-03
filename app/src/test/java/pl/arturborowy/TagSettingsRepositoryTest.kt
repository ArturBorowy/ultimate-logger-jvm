package pl.arturborowy

import org.junit.Assert
import org.junit.Test
import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.exception.UltLogNotInitializedException
import pl.arturborowy.logger.tag.TagSettings

class TagSettingsRepositoryTest {

    private val tagSettingsRepository = TagSettingsRepository()

    @Test(expected = UltLogNotInitializedException::class)
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