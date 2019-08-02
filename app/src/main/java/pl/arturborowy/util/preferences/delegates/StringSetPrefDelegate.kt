package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class StringSetPrefDelegate(private val prefs: SharedPreferences,
                            private val defaultValue: Set<String>,
                            onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                            prefKey: String? = null) :
        PrefDelegate<Set<String>?>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Set<String>? =
            prefs.getStringSet(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Set<String>?) {
        prefs.putStringSet(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putStringSet(key: String, value: Set<String>?) =
            edit().putStringSet(key, value).apply()
}