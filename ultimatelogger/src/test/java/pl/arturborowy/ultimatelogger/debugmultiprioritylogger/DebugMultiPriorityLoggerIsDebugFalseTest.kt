package pl.arturborowy.ultimatelogger.debugmultiprioritylogger

import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

class DebugMultiPriorityLoggerIsDebugFalseTest : DebugMultiPriorityLoggerTest(false) {

    @Test
    fun `v() doesn't call v() on givenLogger`() {
        debugMultiPriorityLogger.v(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { v(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `d() doesn't call d() on givenLogger`() {
        debugMultiPriorityLogger.d(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { d(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `i() doesn't call i() on givenLogger`() {
        debugMultiPriorityLogger.i(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { i(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `w() doesn't call w() on givenLogger`() {
        debugMultiPriorityLogger.w(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { w(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `e() doesn't call e() on givenLogger`() {
        debugMultiPriorityLogger.e(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { e(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `wtf() doesn't call wtf() on givenLogger`() {
        debugMultiPriorityLogger.wtf(givenTag, givenMsg, givenThrowable)

        verifyNotCalledOnMockLogger { wtf(givenTag, givenMsg, givenThrowable) }
    }

    @Test
    fun `println() doesn't call println() on givenLogger`() {
        debugMultiPriorityLogger.println(givenPriority, givenMsg, givenMsg)

        verifyNotCalledOnMockLogger { println(givenPriority, givenMsg, givenMsg) }
    }

    private fun verifyNotCalledOnMockLogger(block: MultiPriorityLogger.() -> Unit) =
            verifyCalledOnMockLogger(block, Mockito.never())
}