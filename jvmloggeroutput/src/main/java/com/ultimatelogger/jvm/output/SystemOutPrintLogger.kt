package com.ultimatelogger.jvm.output

import com.ultimatelogger.multiplatform.output.MultiPriorityLogger

internal class SystemOutPrintLogger : MultiPriorityLogger {

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
        log({ printOut(it) }, { printOutLn(it) }, levelName, tag, msg, throwable)
    }

    private fun logErr(levelName: String,
                       tag: String?,
                       msg: String?,
                       throwable: Throwable?) {
        log({ printErr(it) }, { printErrLn(it) }, levelName, tag, msg, throwable)
    }

    private fun log(printPartOfLine: (String) -> Unit,
                    printSingleLine: (String) -> Unit,
                    levelName: String,
                    tag: String?,
                    msg: String?,
                    throwable: Throwable?) {
        if (throwable == null) {
            printSingleLine(buildLog(levelName, tag, msg))
        } else {
            printPartOfLine(buildLog(levelName, tag, msg ?: ""))
            throwable.printStackTrace()
        }
    }

    private fun buildLog(levelName: String, tag: String?, msg: String?): String {
        return "[$levelName] $tag: $msg"
    }

    private fun printOut(string: String?) = System.out.print(string)

    private fun printErr(string: String?) = System.err.print(string)

    private fun printOutLn(string: String?) = System.out.println(string)

    private fun printErrLn(string: String?) = System.err.println(string)
}