package pl.arturborowy.logger.tag.provider.string

interface StringTagProvider {

    fun provide(withFileNameAndLineNum: Boolean?,
                withClassName: Boolean?,
                withMethodName: Boolean?): String
}