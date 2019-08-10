package com.ultimatelogger.multiplatform

/**
 * tw = try with. Tries running given block WITH T-type object as lambda parameter e.g.
 * `object.tw({ it.method() }, { doSthIfObjectIsNull() }) // it == object`
 * If T-type object is null, invokes `doIfNull` lambda parameter.
 */
fun <T> T?.tw(block: (T?) -> Unit, doIfNull: () -> Unit) = ti(block, doIfNull)

/**
 * ti = try inside. Tries running given block INSIDE T-type object e.g.
 * `object.tw({ this.method() }, { doSthIfObjectIsNull() }) // this == object`
 * If T-type object is null, invokes `doIfNull` lambda parameter.
 */
fun <T> T?.ti(block: T.() -> Unit, doIfNull: () -> Unit) =
        if (this == null) {
            doIfNull()
        } else {
            this.block()
        }

/**
 * tw = try with. Tries running given block WITH T-type object as lambda parameter e.g.
 * `object.tw { it.method() } // it == object`
 * If T-type object is null, logs message about unsuccessful trial.
 */
fun <T> T?.tw(block: (T?) -> Unit) = tw(block, { logUnsuccessfulTrial() })

/**
 * ti = try inside. Tries running given block INSIDE T-type object e.g.
 * `object.tw { this.method() } // this == object`
 * If T-type object is null, logs message about unsuccessful trial.
 */
fun <T> T?.ti(block: T.() -> Unit) = ti(block, { logUnsuccessfulTrial() })

private fun logUnsuccessfulTrial() {
    MpUltimateLoggerInitializer.ultimateLogger
            .w("Tried to run block, but given T-type object is null!")
}