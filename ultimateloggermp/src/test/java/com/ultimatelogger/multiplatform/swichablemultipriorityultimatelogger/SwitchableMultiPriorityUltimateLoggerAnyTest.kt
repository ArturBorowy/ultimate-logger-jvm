package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.given
import org.junit.Test
import org.mockito.Mockito
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.output.SwitchableMultiPriorityLogger

internal class SwitchableMultiPriorityUltimateLoggerAnyTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(Any, ) calls logger v() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    v(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    v(tag, stringedAny)
                }
        )
    }

    private fun verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
            switchableMultiPriorityUltimateLoggerAction:
            SwitchableMultiPriorityUltimateLogger.(Any, Boolean, Boolean, Boolean) -> Unit,
            SwitchableMultiPriorityLoggerAction:
            SwitchableMultiPriorityLogger.(String, String) -> Unit) {
        val givenAny = Any()

        val givenWithFileNameAndLineNum = true
        val givenWithClassName = true
        val givenWithMethodName = true

        val givenTag = "]2[3l;]23;]"

        given(mockStringTagProvider.provide(givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName))
                .willReturn(givenTag)

        switchableMultiPriorityUltimateLogger.switchableMultiPriorityUltimateLoggerAction(givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        Mockito.verify(mockSwitchableMultiPriorityLogger, Mockito.times(1))
                .SwitchableMultiPriorityLoggerAction(givenTag, givenAny.toString())
    }

    @Test
    fun `d(Any, ) calls logger d() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    d(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    d(tag, stringedAny)
                }
        )
    }

    @Test
    fun `i(Any, ) calls logger i() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    i(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    i(tag, stringedAny)
                }
        )
    }

    @Test
    fun `w(Any, ) calls logger w() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    w(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    w(tag, stringedAny)
                }
        )
    }

    @Test
    fun `e(Any, ) calls logger e() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    e(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    e(tag, stringedAny)
                }
        )
    }

    @Test
    fun `wtf(Any, ) calls logger wtf() with stringed anything and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { any,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    wtf(any, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  stringedAny ->
                    wtf(tag, stringedAny)
                }
        )
    }
}