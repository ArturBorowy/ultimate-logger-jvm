package pl.arturborowy.android.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.androidloggeroutput.ALog
import pl.arturborowy.androidloggeroutput.AndroidUltLogInitializer
import pl.arturborowy.tagsettings.TagSettings
import pl.arturborowy.ultimatelogger.tw

internal class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidUltLogInitializer.init(true, TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true))

        ALog.e("12345")
        ALog.e(Exception())

        (null as String?).tw {  }
    }
}