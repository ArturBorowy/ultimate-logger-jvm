package pl.arturborowy.logger.tag.builder

import pl.arturborowy.logger.tag.dataprovider.TagData

interface TagDataTagBuilder {

    fun build(tagData: TagData?,
              withFileNameAndLineNr: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String
}