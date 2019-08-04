package pl.arturborowy.ultimatelogger.tag.provider.string

interface StringTagProvider {

    fun provide(withFileNameAndLineNum: Boolean?,
                withClassName: Boolean?,
                withMethodName: Boolean?): String
}