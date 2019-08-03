package pl.arturborowy.ultimatelogger

import org.junit.Test

class UltLogTest {

    @Test
    fun `e(String, ) throws UltLogNotInitializedException if init wasn't called before`() {

    }

    @Test
    fun `e(String, ) doesn't throw UltLogNotInitializedException if init was called before`() {

    }

    @Test
    fun `e(Throwable, ) throws UltLogNotInitializedException if init wasn't called before`() {

    }

    @Test
    fun `e(Throwable, ) doesn't throw UltLogNotInitializedException if init was called before`() {

    }

    @Test
    fun `e(String, ) calls logger e(, String) with tag from tagBuilder build`() {

    }

    @Test
    fun `e(Throwable, ) calls logger e(, Throwable) with tag from tagBuilder buildForThrowable`() {

    }

    @Test
    fun `e(AnyT, ) calls e(, String) with stringed anything`() {

    }
}