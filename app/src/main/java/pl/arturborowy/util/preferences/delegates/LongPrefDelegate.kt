package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class LongPrefDelegate(private val prefs: SharedPreferences,
                       private val defaultValue: Long,
                       onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                       prefKey: String? = null) : PrefDelegate<Long>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getLong(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        prefs.putLong(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putLong(key: String, value: Long) =
            edit().putLong(key, value).apply()
}