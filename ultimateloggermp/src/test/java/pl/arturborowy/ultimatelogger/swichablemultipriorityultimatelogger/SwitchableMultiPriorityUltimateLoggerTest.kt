package pl.arturborowy.ultimatelogger.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import pl.arturborowy.ultimatelogger.SwitchableMultiPriorityUltimateLogger
import pl.arturborowy.ultimatelogger.output.SwitchableMultiPriorityLogger
import pl.arturborowy.ultimatelogger.tag.provider.string.StringTagProvider
import pl.arturborowy.ultimatelogger.tag.provider.throwable.ThrowableTagProvider

internal abstract class SwitchableMultiPriorityUltimateLoggerTest {

    protected val mockSwitchableMultiPriorityLogger: SwitchableMultiPriorityLogger = mock()
    protected val mockStringTagProvider: StringTagProvider = mock()
    protected val mockThrowableTagProvider: ThrowableTagProvider = mock()

    protected lateinit var switchableMultiPriorityUltimateLogger: SwitchableMultiPriorityUltimateLogger

    @Before
    fun setUp() {
        startKoin {
            modules(
                    module {
                        single { mockSwitchableMultiPriorityLogger }
                        single { mockStringTagProvider }
                        single { mockThrowableTagProvider }
                    }
            )
        }

        switchableMultiPriorityUltimateLogger = object : SwitchableMultiPriorityUltimateLogger() {}
    }

    @After
    fun tearDown() = stopKoin()
}