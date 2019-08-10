package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.given
import org.junit.Test
import org.mockito.Mockito
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.output.SwitchableMultiPriorityLogger

internal class SwitchableMultiPriorityUltimateLoggerMsgTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(String, ) calls logger v() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    v(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    v(tag, msg)
                }
        )
    }

    private fun verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
            switchableMultiPriorityUltimateLoggerAction:
            SwitchableMultiPriorityUltimateLogger.(String, Boolean, Boolean, Boolean) -> Unit,
            SwitchableMultiPriorityLoggerAction:
            SwitchableMultiPriorityLogger.(String, String) -> Unit) {
        val givenMsg = "][qr;e[;]l]["

        val givenWithFileNameAndLineNum = true
        val givenWithClassName = true
        val givenWithMethodName = true

        val givenTag = "]2[3l;]23;]"

        given(mockStringTagProvider.provide(givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName))
                .willReturn(givenTag)

        switchableMultiPriorityUltimateLogger.switchableMultiPriorityUltimateLoggerAction(givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        Mockito.verify(mockSwitchableMultiPriorityLogger, Mockito.times(1))
                .SwitchableMultiPriorityLoggerAction(givenTag, givenMsg)
    }

    @Test
    fun `d(String, ) calls logger d() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    d(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    d(tag, msg)
                }
        )
    }

    @Test
    fun `i(String, ) calls logger i() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    i(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    i(tag, msg)
                }
        )
    }

    @Test
    fun `w(String, ) calls logger w() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    w(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    w(tag, msg)
                }
        )
    }

    @Test
    fun `e(String, ) calls logger e() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    e(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    e(tag, msg)
                }
        )
    }

    @Test
    fun `wtf(String, ) calls logger wtf() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    wtf(msg, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    wtf(tag, msg)
                }
        )
    }
}