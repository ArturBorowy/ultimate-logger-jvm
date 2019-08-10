package com.ultimatelogger.multiplatform.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Similar to Kotlin's `Delegates.notNull()`, but with custom throwable.
 */
internal class CryptoNullable<ValueT>(private val throwableToThrowIfNull: Throwable) :
        ReadWriteProperty<Any?, ValueT> {

    private var storedValue: ValueT? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): ValueT =
            storedValue ?: throw throwableToThrowIfNull

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: ValueT) {
        storedValue = value
    }
}