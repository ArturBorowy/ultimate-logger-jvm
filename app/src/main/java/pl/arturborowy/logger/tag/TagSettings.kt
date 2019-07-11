package pl.arturborowy.logger.tag

data class TagSettings(val shouldLogFileNameAndLineNr: Boolean,
                       val shouldLogClassName: Boolean,
                       val shouldLogMethodName: Boolean)