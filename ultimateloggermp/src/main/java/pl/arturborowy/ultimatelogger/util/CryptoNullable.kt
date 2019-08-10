package pl.arturborowy.ultimatelogger.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Similar to Kotlin's `Delegates.notNull()`, but with custom throwable.
 */
class CryptoNullable<ValueT>(private val throwableToThrowIfNull: Throwable) :
        ReadWriteProperty<ValueT, ValueT> {

    private var storedValue: ValueT? = null

    override fun getValue(thisRef: ValueT, property: KProperty<*>): ValueT =
            storedValue ?: throw throwableToThrowIfNull

    override fun setValue(thisRef: ValueT, property: KProperty<*>, value: ValueT) {
        storedValue = value
    }
}