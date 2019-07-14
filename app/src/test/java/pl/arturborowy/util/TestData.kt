package pl.arturborowy.util

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider

internal object TestData {

    fun getContext(): Context = ApplicationProvider.getApplicationContext<Application>()
}