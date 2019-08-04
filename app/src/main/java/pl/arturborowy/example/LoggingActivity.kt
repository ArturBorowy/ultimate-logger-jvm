package pl.arturborowy.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.androidloggeroutput.AndroidUltLogInitializer
import pl.arturborowy.ultimatelogger.UltLog
import pl.arturborowy.ultimatelogger.tag.TagSettings

class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidUltLogInitializer.init( true, TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true))

        UltLog.e("12345")
        UltLog.e(Exception())
    }
}