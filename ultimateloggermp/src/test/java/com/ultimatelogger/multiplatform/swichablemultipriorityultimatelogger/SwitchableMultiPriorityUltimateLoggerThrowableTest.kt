package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.given
import org.junit.Test
import org.mockito.Mockito
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.output.SwitchableMultiPriorityLogger

internal class SwitchableMultiPriorityUltimateLoggerThrowableTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(Throwable, ) calls logger v() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg ->
                    v(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    v(tag, msg, throwable)
                }
        )
    }

    private fun verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
            switchableMultiPriorityUltimateLoggerAction:
            SwitchableMultiPriorityUltimateLogger.(Throwable, String) -> Unit,
            SwitchableMultiPriorityLoggerAction:
            SwitchableMultiPriorityLogger.(String, String, Throwable) -> Unit) {
        val givenMsg = "tp[flw2g[pk4m["
        val givenThrowable = Exception()

        val givenTag = "]2[3l;]23;]"

        given(mockThrowableTagProvider.provide()).willReturn(givenTag)

        switchableMultiPriorityUltimateLogger
                .switchableMultiPriorityUltimateLoggerAction(givenThrowable, givenMsg)

        Mockito.verify(mockSwitchableMultiPriorityLogger, Mockito.times(1))
                .SwitchableMultiPriorityLoggerAction(givenTag, givenMsg, givenThrowable)
    }

    @Test
    fun `d(Throwable, ) calls logger d() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable,
                  msg ->
                    d(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    d(tag, msg, throwable)
                }
        )
    }

    @Test
    fun `i(Throwable, ) calls logger i() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable,
                  msg ->
                    i(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    i(tag, msg, throwable)
                }
        )
    }

    @Test
    fun `w(Throwable, ) calls logger w() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable,
                  msg ->
                    w(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    w(tag, msg, throwable)
                }
        )
    }

    @Test
    fun `e(Throwable, ) calls logger e() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable,
                  msg ->
                    e(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    e(tag, msg, throwable)
                }
        )
    }

    @Test
    fun `wtf(Throwable, ) calls logger wtf() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable,
                  msg ->
                    wtf(throwable, msg)
                },
                { tag,
                  msg,
                  throwable ->
                    wtf(tag, msg, throwable)
                }
        )
    }
}