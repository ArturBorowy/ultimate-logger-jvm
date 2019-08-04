package pl.arturborowy.ultimatelogger

import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import pl.arturborowy.ultimatelogger.di.ServiceLocatorInitializer
import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

internal class ServiceLocatorInitializerTest {

    private val mockMultiPriorityLogger: MultiPriorityLogger = mock()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test(expected = KoinAppAlreadyStartedException::class)
    fun `init starts Koin, so second call throws exception`() {
        ServiceLocatorInitializer.init(mockMultiPriorityLogger)
        ServiceLocatorInitializer.init(mockMultiPriorityLogger)
    }

    @Test
    fun `destroy stops Koin, so second call doesn't throw exception`() {
        ServiceLocatorInitializer.init(mockMultiPriorityLogger)

        ServiceLocatorInitializer.destroy()

        ServiceLocatorInitializer.init(mockMultiPriorityLogger)
    }
}