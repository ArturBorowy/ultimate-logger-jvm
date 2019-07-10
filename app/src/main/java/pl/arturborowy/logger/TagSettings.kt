package pl.arturborowy.logger

data class TagSettings(val shouldLogFileNameAndLineNr: Boolean,
                       val shouldLogClassName: Boolean,
                       val shouldLogMethodName: Boolean)