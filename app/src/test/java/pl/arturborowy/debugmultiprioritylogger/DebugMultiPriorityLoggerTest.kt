package pl.arturborowy.debugmultiprioritylogger

import com.nhaarman.mockitokotlin2.mock
import org.mockito.Mockito
import org.mockito.verification.VerificationMode
import pl.arturborowy.logger.output.DebugMultiPriorityLogger
import pl.arturborowy.logger.output.MultiPriorityLogger


abstract class DebugMultiPriorityLoggerTest(isDebug: Boolean) {

    protected val mockLogger: MultiPriorityLogger = mock()

    protected val debugMultiPriorityLogger = DebugMultiPriorityLogger(mockLogger, isDebug)

    protected val givenTag = "12345"
    protected val givenMsg = "[]];"
    protected val givenThrowable: Throwable = Exception()
    protected val givenPriority = 1

    protected fun verifyCalledOnMockLogger(block: MultiPriorityLogger.() -> Unit,
                                         times: VerificationMode) =
            Mockito.verify(mockLogger, times).block()
}