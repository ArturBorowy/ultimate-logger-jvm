package pl.arturborowy.util.preferences.delegates

import android.content.SharedPreferences
import kotlin.reflect.KProperty

class FloatPrefDelegate(private val prefs: SharedPreferences,
                        private val defaultValue: Float,
                        onPrefChangedAction: ((KProperty<*>) -> Unit)? = null,
                        prefKey: String? = null) :
        PrefDelegate<Float>(prefKey, onPrefChangedAction) {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getFloat(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        prefs.putFloat(prefKey ?: property.name, value)
        super.setValue(thisRef, property, value)
    }

    private fun SharedPreferences.putFloat(key: String, value: Float) =
            edit().putFloat(key, value).apply()
}