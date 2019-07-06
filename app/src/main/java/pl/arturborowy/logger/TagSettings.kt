package pl.arturborowy.logger

data class TagSettings(val shouldLogFileName: Boolean,
                       val shouldLogClassName: Boolean,
                       val shouldLogMethodName: Boolean,
                       val shouldLogLineNr: Boolean)