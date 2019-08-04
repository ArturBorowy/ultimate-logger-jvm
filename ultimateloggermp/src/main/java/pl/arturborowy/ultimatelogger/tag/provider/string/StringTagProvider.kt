package pl.arturborowy.ultimatelogger.tag.provider.string

internal interface StringTagProvider {

    fun provide(withFileNameAndLineNum: Boolean?,
                withClassName: Boolean?,
                withMethodName: Boolean?): String
}