package pl.arturborowy.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.ultimatelogger.UltLog
import pl.arturborowy.ultimatelogger.UltLogInitializer
import pl.arturborowy.ultimatelogger.tag.TagSettings

class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UltLogInitializer.initDebug(this, true, TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true))

        UltLog.e("12345")
        UltLog.e(Exception())
    }
}