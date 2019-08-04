package pl.arturborowy.ultimatelogger.exception

internal class UltLogNotInitializedException : Exception("UltLog has not been initialized. " +
        "Please call UltLogInitializer.init(...) before logging.")