package pl.arturborowy.ultimatelogger.tag.builder

import pl.arturborowy.ultimatelogger.tag.dataprovider.TagData

internal interface TagDataTagBuilder {

    fun build(tagData: TagData?,
              withFileNameAndLineNum: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String
}