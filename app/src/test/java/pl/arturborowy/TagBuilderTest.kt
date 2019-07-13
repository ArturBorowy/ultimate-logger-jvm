package pl.arturborowy

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.logger.tag.dataprovider.StackTraceElementReceiver
import pl.arturborowy.logger.tag.TagBuilder
import pl.arturborowy.logger.tag.TagSettings

class TagBuilderTest {

    companion object {
        private const val givenClassName = "ClassName"
        private const val givenFileName = "FileName.kt"
        private const val givenLineNr = 89
        private const val givenMethodName = "methodName"
    }

    @Test
    fun `build returns empty string if stackTraceElement is null`() {
        val mockStackTraceElementReceiver: StackTraceElementReceiver = mock()
        val mockDefaultTagSettings: TagSettings = mock()

        val tagBuilder = TagBuilder(mockStackTraceElementReceiver, mockDefaultTagSettings)

        given(mockStackTraceElementReceiver.getData())
                .willReturn(null)

        val actualTag = tagBuilder.build(withFileNameAndLineNr = false,
                withClassName = false,
                withMethodName = false)

        Assert.assertEquals("", actualTag)
    }

    @Test
    fun `build uses defaultTagSettings if arguments are null`() {
        val mockStackTraceElementReceiver: StackTraceElementReceiver = mock()

        val givenShouldLogFileName = true
        val givenShouldLogFileNameAndLineNr = true
        val givenShouldLogMethodName = true

        val spyDefaultTagSettings = spy(TagSettings(givenShouldLogFileName,
                givenShouldLogFileNameAndLineNr,
                givenShouldLogMethodName))

        val tagBuilder = TagBuilder(mockStackTraceElementReceiver, spyDefaultTagSettings)

        given(mockStackTraceElementReceiver.getData())
                .willReturn(StackTraceElement(givenClassName, givenMethodName,
                        givenFileName, givenLineNr))

        tagBuilder.build(null,
                null,
                null)

        assertEveryPropertyAccessed(spyDefaultTagSettings)
    }

    private fun assertEveryPropertyAccessed(tagSettings: TagSettings) {
        Mockito.verify(tagSettings, Mockito.times(1))
                .shouldLogFileNameAndLineNr

        Mockito.verify(tagSettings, Mockito.times(1))
                .shouldLogClassName

        Mockito.verify(tagSettings, Mockito.times(1))
                .shouldLogMethodName
    }

    @Test // expected tag case "(FileName.kt:89) ClassName.methodName()"
    fun `build with all arguments true returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = true,
                    withClassName = true,
                    withMethodName = true,
                    expectedTag = "($givenFileName:$givenLineNr) $givenClassName.$givenMethodName()")

    private fun assertBuiltTag(withFileNameAndLineNr: Boolean,
                               withClassName: Boolean,
                               withMethodName: Boolean,
                               expectedTag: String) {
        val mockStackTraceElementReceiver: StackTraceElementReceiver = mock()

        val spyDefaultTagSettings: TagSettings = mock()

        val tagBuilder = TagBuilder(mockStackTraceElementReceiver, spyDefaultTagSettings)

        given(mockStackTraceElementReceiver.getData())
                .willReturn(StackTraceElement(givenClassName, givenMethodName,
                        givenFileName, givenLineNr))

        val actualTag = tagBuilder.build(withFileNameAndLineNr, withClassName, withMethodName)

        Assert.assertEquals(expectedTag, actualTag)
    }

    @Test
    fun `build with all arguments false returns " "`() =
            assertBuiltTag(withFileNameAndLineNr = false,
                    withClassName = false,
                    withMethodName = false,
                    expectedTag = " ")

    @Test // expected tag case "(FileName.kt:89)"
    fun `build(true, false, false) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = true,
                    withClassName = false,
                    withMethodName = false,
                    expectedTag = "($givenFileName:$givenLineNr)")

    @Test // expected tag case "(FileName.kt:89) ClassName"
    fun `build(true, true, false) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = true,
                    withClassName = true,
                    withMethodName = false,
                    expectedTag = "($givenFileName:$givenLineNr) $givenClassName")

    @Test // expected tag case "ClassName"
    fun `build(false, true, false) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = false,
                    withClassName = true,
                    withMethodName = false,
                    expectedTag = givenClassName)

    @Test // expected tag case ".methodName()"
    fun `build(false, false, true) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = false,
                    withClassName = false,
                    withMethodName = true,
                    expectedTag = ".$givenMethodName()")

    @Test // expected tag case "(FileName.kt:89) .methodName()"
    fun `build(true, false, true) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = true,
                    withClassName = false,
                    withMethodName = true,
                    expectedTag = "($givenFileName:$givenLineNr) .$givenMethodName()")

    @Test // expected tag case "ClassName.methodName()"
    fun `build(false, true, true) returns tag in correct case`() =
            assertBuiltTag(withFileNameAndLineNr = false,
                    withClassName = true,
                    withMethodName = true,
                    expectedTag = "$givenClassName.$givenMethodName()")

    @Test
    fun `buildForThrowable calls build on self with correct arguments`() {
        val mockStackTraceElementReceiver: StackTraceElementReceiver = mock()
        val mockDefaultTagSettings: TagSettings = mock()

        val tagBuilder = TagBuilder(mockStackTraceElementReceiver, mockDefaultTagSettings)

        val spyTagBuilder = spy(tagBuilder)

        spyTagBuilder.buildForThrowable()

        Mockito.verify(spyTagBuilder, Mockito.times(1))
                .build(withFileNameAndLineNr = true,
                        withClassName = false,
                        withMethodName = false)
    }
}