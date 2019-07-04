package pl.arturborowy.util.preferences

import kotlin.reflect.KProperty

interface SharedPrefsListener {

    fun onSharedPrefChanged(property: KProperty<*>)
}