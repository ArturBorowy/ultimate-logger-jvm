package pl.arturborowy.ultimatelogger.exception

class UltLogNotInitializedException : Exception("UltLog has not been initialized. " +
        "Please call UltLogInitializer.init(...) before logging.")