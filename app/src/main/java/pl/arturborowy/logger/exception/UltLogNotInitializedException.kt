package pl.arturborowy.logger.exception

class UltLogNotInitializedException : Exception("UltLog has not been initialized. " +
        "Please call UltLogInitializer.init(...) before logging.")