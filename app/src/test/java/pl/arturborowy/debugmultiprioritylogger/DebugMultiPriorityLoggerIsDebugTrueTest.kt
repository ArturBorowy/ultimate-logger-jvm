package pl.arturborowy.debugmultiprioritylogger

import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.logger.output.MultiPriorityLogger

class DebugMultiPriorityLoggerIsDebugTrueTest : DebugMultiPriorityLoggerTest(true) {

    @Test
    fun `v() calls v() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { v(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `d() calls d() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { d(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `i() calls i() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { i(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `w() calls w() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { w(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `e() calls e() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { e(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `wtf() calls wtf() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        verifyCalledOnceOnMockLogger { wtf(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `println() calls println() with same arguments on givenLogger`() {
        debugMultiPriorityLogger.println(givenPriority, givenMsg, givenMsg)

        verifyCalledOnceOnMockLogger { println(givenPriority, givenMsg, givenMsg) }
    }

    private fun verifyCalledOnceOnMockLogger(block: MultiPriorityLogger.() -> Unit) =
            verifyCalledOnMockLogger(block, Mockito.times(1))
}