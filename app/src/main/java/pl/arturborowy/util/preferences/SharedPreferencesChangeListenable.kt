package pl.arturborowy.util.preferences

import kotlin.reflect.KProperty

abstract class SharedPreferencesChangeListenable {

    private val listeners = mutableListOf<SharedPrefsListener>()

    fun addListener(sharedPrefsListener: SharedPrefsListener) {
        listeners.add(sharedPrefsListener)
    }

    fun removeListener(sharedPrefsListener: SharedPrefsListener) {
        listeners.remove(sharedPrefsListener)
    }

    fun clearListeners() = listeners.clear()

    fun onPrefChanged(property: KProperty<*>) =
            listeners.forEach { it.onSharedPrefChanged(property) }
}