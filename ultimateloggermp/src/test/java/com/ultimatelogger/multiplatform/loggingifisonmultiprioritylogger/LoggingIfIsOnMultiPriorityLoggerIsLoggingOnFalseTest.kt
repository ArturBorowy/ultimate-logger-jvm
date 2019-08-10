package com.ultimatelogger.multiplatform.loggingifisonmultiprioritylogger

import org.junit.Test
import org.mockito.Mockito
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class LoggingIfIsOnMultiPriorityLoggerIsLoggingOnFalseTest :
        LoggingIfIsOnMultiPriorityLoggerTest(false) {

    @Test
    fun `v() doesn't call v() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { v(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `d() doesn't call d() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { d(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `i() doesn't call i() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { i(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `w() doesn't call w() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { w(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `e() doesn't call e() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { e(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `wtf() doesn't call wtf() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { wtf(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `println() doesn't call println() on givenLogger`() {
        loggingIfIsOnMultiPriorityLogger.println(givenPriority, givenMsg, givenMsg)

        verifyNotCalledOnMockLogger { println(givenPriority, givenMsg, givenMsg) }
    }

    private fun verifyNotCalledOnMockLogger(block: MultiPriorityLogger.() -> Unit) =
            verifyCalledOnMockLogger(block, Mockito.never())
}