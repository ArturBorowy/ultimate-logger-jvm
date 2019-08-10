package pl.arturborowy.androidloggeroutput

internal class MessageForThrowableLogParser {

    fun getMsg(msg: String?, givenThrowable: Throwable?): String? =
            if (msg == null && givenThrowable == null) {
                "null"
            } else {
                msg ?: ""
            }
}