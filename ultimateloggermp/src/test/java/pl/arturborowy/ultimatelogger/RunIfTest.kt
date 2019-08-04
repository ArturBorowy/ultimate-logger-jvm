package pl.arturborowy.ultimatelogger

import com.nhaarman.mockitokotlin2.mock
import org.junit.Test
import org.mockito.Mockito
import pl.arturborowy.ultimatelogger.util.runIf

internal class RunIfTest {

    private val dummyObjectWithMethod: DummyClassWithMethod = mock()

    @Test
    fun `runs given block if condition is true`() {
        runIf(true) { dummyObjectWithMethod.emptyMethod() }

        Mockito.verify(dummyObjectWithMethod, Mockito.times(1))
                .emptyMethod()
    }

    @Test
    fun `doesn't run given block if condition is false`() {
        runIf(false) { dummyObjectWithMethod.emptyMethod() }

        Mockito.verify(dummyObjectWithMethod, Mockito.never())
                .emptyMethod()
    }

    private class DummyClassWithMethod {

        fun emptyMethod() {}
    }
}