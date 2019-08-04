package pl.arturborowy.jvmloggeroutput

import pl.arturborowy.ultimatelogger.output.MultiPriorityLogger

class SytemOutPrintLogger : MultiPriorityLogger {

    override fun v(tag: String?, msg: String?, throwable: Throwable?) {
        logOut("VERBOSE", tag, msg, throwable)
    }

    override fun d(tag: String?, msg: String?, throwable: Throwable?) {
        logOut("DEBUG", tag, msg, throwable)
    }

    override fun i(tag: String?, msg: String?, throwable: Throwable?) {
        logOut("INFO", tag, msg, throwable)
    }

    override fun w(tag: String?, msg: String?, throwable: Throwable?) {
        logErr("WARN", tag, msg, throwable)
    }

    override fun e(tag: String?, msg: String?, throwable: Throwable?) {
        logErr("ERROR", tag, msg, throwable)
    }

    override fun wtf(tag: String?, msg: String?, throwable: Throwable?) {
        logErr("WTF", tag, msg, throwable)
    }

    override fun println(priority: Int, tag: String?, msg: String?) {
        logOut(priority.toString(), tag, msg, null)
    }

    private fun logOut(levelName: String,
                       tag: String?,
                       msg: String?,
                       throwable: Throwable?) {
        log({ printOut(it) }, levelName, tag, msg, throwable)
    }

    private fun logErr(levelName: String,
                       tag: String?,
                       msg: String?,
                       throwable: Throwable?) {
        log({ printErr(it) }, levelName, tag, msg, throwable)
    }

    private fun log(printer: (String) -> Unit,
                    levelName: String,
                    tag: String?,
                    msg: String?,
                    throwable: Throwable?) {
        if (throwable == null) {
            printer(buildLog(levelName, tag, msg))
            startNextLine()
        } else {
            printer(buildLog(levelName, tag, msg ?: ""))
            throwable.printStackTrace()
        }
    }

    private fun buildLog(levelName: String, tag: String?, msg: String?): String {
        return "[$levelName] $tag: $msg"
    }

    private fun startNextLine() = System.out.println()

    private fun printOut(string: String?) = System.out.print(string)

    private fun printErr(string: String?) = System.err.print(string)
}