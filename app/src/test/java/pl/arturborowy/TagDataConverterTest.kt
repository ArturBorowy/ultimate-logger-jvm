package pl.arturborowy

import org.junit.Assert
import org.junit.Test
import pl.arturborowy.logger.tag.dataprovider.TagData
import pl.arturborowy.logger.tag.dataprovider.TagDataConverter

class TagDataConverterTest {

    private val givenClassName = "givenClassName"
    private val givenFileName = "givenFileName"
    private val givenMethodName = "givenMethodName"
    private val givenLineNum = 12

    private val tagDataConverter = TagDataConverter()

    @Test
    fun `fromStackTraceElement returns TagData with data from given stackTraceElement`() {
        val givenStackTraceElement = StackTraceElement(givenClassName,
                givenMethodName, givenFileName, givenLineNum)

        val actualTagData = tagDataConverter.fromStackTraceElement(givenStackTraceElement)

        assertTagDataHasGivenDataSet(actualTagData)
    }

    private fun assertTagDataHasGivenDataSet(actualTagData: TagData) {
        Assert.assertEquals(givenClassName, actualTagData.className)
        Assert.assertEquals(givenFileName, actualTagData.fileName)
        Assert.assertEquals(givenMethodName, actualTagData.methodName)
        Assert.assertEquals(givenLineNum, actualTagData.lineNumber.toInt())
    }
}