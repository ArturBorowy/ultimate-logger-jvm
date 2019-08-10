package com.ultimatelogger.android.output.tag

class AndroidTagCutter(private val apiVersion: Int) : TagCutter {

    companion object {
        private const val TAG_LENGTH_LIMIT = 23
        private const val HIGHEST_API_WITH_TAG_LENGTH_LIMIT = 23
    }

    override fun toLimit(tag: String?) =
            if (shouldCutTag(tag)) {
                cutTag(tag!!)
            } else {
                tag
            }

    private fun shouldCutTag(tag: String?) =
            tag != null
                    && tag.length > TAG_LENGTH_LIMIT
                    && apiVersion < HIGHEST_API_WITH_TAG_LENGTH_LIMIT

    private fun cutTag(tag: String) = tag.substring(0, TAG_LENGTH_LIMIT)
}