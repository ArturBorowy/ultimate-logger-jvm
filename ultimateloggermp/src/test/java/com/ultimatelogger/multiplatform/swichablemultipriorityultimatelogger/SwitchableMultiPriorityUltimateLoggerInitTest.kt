package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import org.junit.Test
import org.mockito.Mockito

internal class SwitchableMultiPriorityUltimateLoggerInitTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(Any, ) calls logger v() with stringed anything and tag from stringTagProvider`() {
        val givenShouldLog = true

        switchableMultiPriorityUltimateLogger.init(givenShouldLog)

        Mockito.verify(mockSwitchableMultiPriorityLogger, Mockito.times(1))
                .isLoggingOn = givenShouldLog
    }
}