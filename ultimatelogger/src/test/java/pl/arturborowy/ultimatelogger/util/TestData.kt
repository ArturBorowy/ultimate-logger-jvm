package pl.arturborowy.ultimatelogger.util

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import pl.arturborowy.ultimatelogger.tag.dataprovider.TagData

internal object TestData {

    fun getContext(): Context = ApplicationProvider.getApplicationContext<Application>()

    fun getTagData() =
            TagData("fileName",
                    "className",
                    "methodName",
                    "12")
}