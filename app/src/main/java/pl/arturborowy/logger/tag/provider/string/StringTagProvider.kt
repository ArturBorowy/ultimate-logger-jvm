package pl.arturborowy.logger.tag.provider.string

interface StringTagProvider {

    fun provide(withFileNameAndLineNr: Boolean?,
                withClassName: Boolean?,
                withMethodName: Boolean?): String
}