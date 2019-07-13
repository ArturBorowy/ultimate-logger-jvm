package pl.arturborowy.logger.tag

import kotlin.reflect.KClass

data class TagSettings(val shouldLogFileNameAndLineNr: Boolean,
                       val shouldLogClassName: Boolean,
                       val shouldLogMethodName: Boolean,
                       val classesToIgnore: MutableList<KClass<*>> = mutableListOf())