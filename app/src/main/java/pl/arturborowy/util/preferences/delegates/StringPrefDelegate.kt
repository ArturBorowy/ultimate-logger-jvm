package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class StringPrefDelegate(private val prefs: SharedPreferences,
                         private val defaultValue: String?,
                         onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                         prefKey: String? = null) :
        PrefDelegate<String?>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>): String? =
            prefs.getString(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        prefs.putString(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putString(key: String, value: String?) =
            edit().putString(key, value).apply()
}