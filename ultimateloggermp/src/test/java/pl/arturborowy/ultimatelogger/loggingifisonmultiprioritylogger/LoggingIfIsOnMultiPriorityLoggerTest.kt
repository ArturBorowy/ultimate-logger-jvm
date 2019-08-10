package pl.arturborowy.ultimatelogger.loggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.mock
import org.mockito.Mockito
import org.mockito.verification.VerificationMode
import pl.arturborowy.ultimatelogger.output.LoggingIfIsOnMultiPriorityLogger
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

internal abstract class LoggingIfIsOnMultiPriorityLoggerTest(isLoggingOn: Boolean) {

    protected val mockLogger: MultiPriorityLogger = mock()

    protected val loggingIfIsOnMultiPriorityLogger =
            LoggingIfIsOnMultiPriorityLogger(mockLogger, isLoggingOn)

    protected val givenTag = "12345"
    protected val givenMsg = "[]];"
    protected val givenThrowable: Throwable = Exception()
    protected val givenPriority = 1

    protected fun verifyCalledOnMockLogger(block: MultiPriorityLogger.() -> Unit,
                                           times: VerificationMode) =
            Mockito.verify(mockLogger, times).block()
}