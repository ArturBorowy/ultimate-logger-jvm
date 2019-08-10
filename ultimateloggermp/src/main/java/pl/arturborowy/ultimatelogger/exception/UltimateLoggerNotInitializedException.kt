package pl.arturborowy.ultimatelogger.exception

internal class UltimateLoggerNotInitializedException : Exception("UltimateLogger has not been initialized. " +
        "Please call MpUltimateLoggerInitializer.init(...) before logging.")