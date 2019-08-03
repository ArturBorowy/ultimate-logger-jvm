package pl.arturborowy.ultimatelogger

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.ultimatelogger.di.ServiceLocatorInitializer
import pl.arturborowy.ultimatelogger.util.TestData

@RunWith(RobolectricTestRunner::class)
class ServiceLocatorInitializerTest {

    private val context = TestData.getContext()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test(expected = KoinAppAlreadyStartedException::class)
    fun `init starts Koin, so second call throws exception`() {
        ServiceLocatorInitializer.init(context)
        ServiceLocatorInitializer.init(context)
    }

    @Test
    fun `destroy stops Koin, so second call doesn't throw exception`() {
        ServiceLocatorInitializer.init(context)

        ServiceLocatorInitializer.destroy()

        ServiceLocatorInitializer.init(context)
    }
}