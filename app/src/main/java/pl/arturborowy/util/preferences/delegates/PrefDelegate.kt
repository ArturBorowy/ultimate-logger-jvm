package pl.arturborowy.util.preferences.delegates

import kotlin.reflect.KProperty

abstract class PrefDelegate<ValueT>(protected val prefKey: String?,
                                    protected val onPrefChangedAction: ((KProperty<*>) -> Unit)?) {

    abstract operator fun getValue(thisRef: Any?, property: KProperty<*>): ValueT

    open operator fun setValue(thisRef: Any?, property: KProperty<*>, value: ValueT) =
            onPrefChangedAction?.invoke(property)
}