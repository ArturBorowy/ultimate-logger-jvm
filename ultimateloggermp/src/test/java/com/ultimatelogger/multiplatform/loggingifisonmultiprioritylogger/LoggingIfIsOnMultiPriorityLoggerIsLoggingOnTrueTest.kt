package com.ultimatelogger.multiplatform.loggingifisonmultiprioritylogger

import org.junit.Test
import org.mockito.Mockito
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class LoggingIfIsOnMultiPriorityLoggerIsLoggingOnTrueTest :
        LoggingIfIsOnMultiPriorityLoggerTest(true) {

    @Test
    fun `v() calls v() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { v(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `d() calls d() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { d(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `i() calls i() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { i(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `w() calls w() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { w(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `e() calls e() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { e(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `wtf() calls wtf() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { wtf(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `println() calls println() with same arguments on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.println(givenPriority, givenMsg, givenMsg)

        verifyCalledOnceOnMockLogger { println(givenPriority, givenMsg, givenMsg) }
    }

    private fun verifyCalledOnceOnMockLogger(block: MultiPriorityLogger.() -> Unit) =
            verifyCalledOnMockLogger(block, Mockito.times(1))
}