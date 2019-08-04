package pl.arturborowy.ultimatelogger.tag.builder

import pl.arturborowy.ultimatelogger.tag.dataprovider.TagData

interface TagDataTagBuilder {

    fun build(tagData: TagData?,
              withFileNameAndLineNum: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String
}