package com.ultimatelogger.android.output

import com.ultimatelogger.android.output.MessageForThrowableLogParser
import org.junit.Assert
import org.junit.Test

class MessageForThrowableLogParserTest {

    private val messageForThrowableLogParser = MessageForThrowableLogParser()

    @Test
    fun `getMsg() returns given msg if msg is not null, but throwable is`() {
        val givenMsg = "fd;sa]fg"

        val actualParsedMsg = messageForThrowableLogParser
                .getMsg(givenMsg, null)

        Assert.assertEquals(givenMsg, actualParsedMsg)
    }

    @Test
    fun `getMsg() returns given msg if msg and throwable is not null`() {
        val givenMsg = "fd;sa]fg"
        val givenThrowable: Throwable? = Exception()

        val actualParsedMsg = messageForThrowableLogParser
                .getMsg(givenMsg, givenThrowable)

        Assert.assertEquals(givenMsg, actualParsedMsg)
    }

    @Test
    fun `getMsg() returns empty string if msg is null, but throwable isn't`() {
        val givenThrowable: Throwable? = Exception()

        val actualParsedMsg = messageForThrowableLogParser.getMsg(null, givenThrowable)

        Assert.assertEquals("", actualParsedMsg)
    }

    @Test
    fun `getMsg() returns null if msg and throwable is null`() {
        val actualParsedMsg = messageForThrowableLogParser.getMsg(null, null)

        Assert.assertEquals("null", actualParsedMsg)
    }
}