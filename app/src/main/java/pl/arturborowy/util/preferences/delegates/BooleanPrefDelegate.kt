package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class BooleanPrefDelegate(private val prefs: SharedPreferences,
                          private val defaultValue: Boolean,
                          onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                          prefKey: String? = null) :
        PrefDelegate<Boolean>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getBoolean(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        prefs.putBoolean(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putBoolean(key: String, value: Boolean) =
            edit().putBoolean(key, value).apply()
}