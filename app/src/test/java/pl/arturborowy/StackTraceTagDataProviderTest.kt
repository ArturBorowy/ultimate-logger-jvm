package pl.arturborowy

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import pl.arturborowy.logger.tag.dataprovider.TagData
import pl.arturborowy.logger.tag.dataprovider.TagDataConverter
import pl.arturborowy.logger.tag.dataprovider.stacktrace.StackTraceElementProvider
import pl.arturborowy.logger.tag.dataprovider.stacktrace.StackTraceTagDataProvider

class StackTraceTagDataProviderTest {

    private val givenClassName = "givenClassName"
    private val givenFileName = "givenFileName"
    private val givenMethodName = "givenMethodName"
    private val givenLineNr = 12

    private val mockStackTraceElementProvider: StackTraceElementProvider = mock()
    private val mockTagDataConverter: TagDataConverter = mock()

    private val stackTraceTagDataProvider = StackTraceTagDataProvider(
            mockStackTraceElementProvider, mockTagDataConverter)

    @Test
    fun `getTagData returns null if stackTraceElement from stackTraceElementProvider is null`() {
        given(mockStackTraceElementProvider.getStackTraceElement())
                .willReturn(null)

        Assert.assertEquals(null, stackTraceTagDataProvider.getTagData())
    }

    @Test
    fun `getTagData returns tagData converted from stackTraceElement`() {
        val givenStackTraceElement = StackTraceElement(givenClassName, givenMethodName,
                givenFileName, givenLineNr)

        given(mockStackTraceElementProvider.getStackTraceElement())
                .willReturn(givenStackTraceElement)

        val expectedTagData: TagData = mock()

        given(mockTagDataConverter.fromStackTraceElement(givenStackTraceElement))
                .willReturn(expectedTagData)

        Assert.assertEquals(expectedTagData, stackTraceTagDataProvider.getTagData())
    }
}