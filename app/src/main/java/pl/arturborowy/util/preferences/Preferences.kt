package pl.arturborowy.util.preferences

import android.content.Context
import android.content.SharedPreferences
import pl.arturborowy.util.preferences.delegates.*

/**
 * Represents a single [SharedPreferences] file.
 *
 * Usage example in Settings.kt
 */
abstract class Preferences(context: Context) : SharedPreferencesChangeListenable() {

    private val prefs by lazy {
        context.getSharedPreferences(javaClass.simpleName, Context.MODE_PRIVATE)
    }

    fun stringPref(defaultValue: String? = null, prefKey: String? = null) =
            StringPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)

    fun intPref(defaultValue: Int = 0, prefKey: String? = null) =
            IntPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)

    fun floatPref(defaultValue: Float = 0f, prefKey: String? = null) =
            FloatPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)

    fun booleanPref(defaultValue: Boolean = false, prefKey: String? = null) =
            BooleanPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)

    fun longPref(defaultValue: Long = 0L, prefKey: String? = null) =
            LongPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)

    fun stringSetPref(defaultValue: Set<String> = HashSet(), prefKey: String? = null) =
            StringSetPrefDelegate(prefs, defaultValue, { onPrefChanged(it) }, prefKey)
}