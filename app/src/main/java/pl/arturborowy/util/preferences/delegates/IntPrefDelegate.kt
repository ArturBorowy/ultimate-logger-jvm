package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class IntPrefDelegate(private val prefs: SharedPreferences,
                      private val defaultValue: Int,
                      onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                      prefKey: String? = null) : PrefDelegate<Int>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getInt(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        prefs.putInt(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putInt(key: String, value: Int) =
            edit().putInt(key, value).apply()
}