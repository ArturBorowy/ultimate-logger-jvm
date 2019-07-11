package pl.arturborowy.logger

fun <T> T?.tryWithOrLog(block: (T?) -> Unit) = tryOnOrLog(block)

fun <T> T?.tryOnOrLog(block: T.() -> Unit) =
        if (this == null) {
            UltLog.e("Tried to run block, but given T-type object is null!")
        } else {
            this.block()
        }