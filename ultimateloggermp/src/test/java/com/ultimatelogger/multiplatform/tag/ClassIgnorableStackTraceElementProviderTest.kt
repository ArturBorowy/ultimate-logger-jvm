package com.ultimatelogger.multiplatform.tag

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.ClassIgnorableStackTraceElementProvider
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.StackTraceFromThreadProvider
import com.ultimatelogger.multiplatform.util.TestData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class ClassIgnorableStackTraceElementProviderTest {

    private val mockStackTraceFromThreadProvider: StackTraceFromThreadProvider = mock()
    private val mockTagSettingsRepository: TagSettingsRepository = mock()

    private lateinit var classIgnorableStackTraceElementProvider:
            ClassIgnorableStackTraceElementProvider

    @Before
    fun setUp() {
        given(mockTagSettingsRepository.defaultTagSettings)
                .willReturn(
                        TagSettings(
                                shouldLogFileNameAndLineNum = true,
                                shouldLogClassName = true,
                                shouldLogMethodName = true)
                )

        classIgnorableStackTraceElementProvider =
                ClassIgnorableStackTraceElementProvider(
                        mockStackTraceFromThreadProvider,
                        mockTagSettingsRepository)
    }

    @Test
    fun `getStackTraceElement() returns first element from stackTraceFromThreadProvider provide()`() {
        given(mockStackTraceFromThreadProvider.provide()).willReturn(TestData.getStackTrace())

        val expectedStackTraceElement = StackTraceElement("Class1", "Method1", "File1", 1)
        val actualStackTraceElement =
                classIgnorableStackTraceElementProvider.getStackTraceElement()

        Assert.assertEquals(expectedStackTraceElement, actualStackTraceElement)
    }

    @Test
    fun `getStackTraceElement() ignores every class that it should`() {
        given(mockStackTraceFromThreadProvider.provide())
                .willReturn(TestData.getStackTraceWithElementsShouldBeIgnored())

        val expectedStackTraceElement = StackTraceElement("Class4", "Method4", "File4", 4)
        val actualStackTraceElement =
                classIgnorableStackTraceElementProvider.getStackTraceElement()

        Assert.assertEquals(expectedStackTraceElement, actualStackTraceElement)
    }

    @Test
    fun `getStackTraceElement() returns null if stackTraceFromThreadProvider provide() returned null`() {
        given(mockStackTraceFromThreadProvider.provide()).willReturn(null)

        val actualStackTraceElement =
                classIgnorableStackTraceElementProvider.getStackTraceElement()

        Assert.assertEquals(null, actualStackTraceElement)
    }
}