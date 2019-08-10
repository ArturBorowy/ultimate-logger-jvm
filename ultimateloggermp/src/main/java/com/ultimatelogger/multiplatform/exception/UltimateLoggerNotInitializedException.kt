package com.ultimatelogger.multiplatform.exception

internal class UltimateLoggerNotInitializedException : Exception("UltimateLogger has not been initialized. " +
        "Please call MpUltimateLoggerInitializer.init(...) before logging.")