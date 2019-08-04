package pl.arturborowy.ultimatelogger.util

import pl.arturborowy.ultimatelogger.tag.dataprovider.TagData

internal object TestData {

    fun getTagData() =
            TagData("fileName",
                    "className",
                    "methodName",
                    "12")
}