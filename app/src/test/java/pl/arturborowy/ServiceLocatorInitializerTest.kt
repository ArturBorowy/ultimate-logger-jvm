package pl.arturborowy

import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.error.KoinAppAlreadyStartedException
import org.robolectric.RobolectricTestRunner
import pl.arturborowy.logger.di.ServiceLocatorInitializer
import pl.arturborowy.util.TestData

@RunWith(RobolectricTestRunner::class)
class ServiceLocatorInitializerTest {

    private val context = TestData.getContext()

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