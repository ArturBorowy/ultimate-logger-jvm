package pl.arturborowy.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.logger.UltLog
import pl.arturborowy.logger.UltLogInitializer
import pl.arturborowy.logger.tag.TagSettings

class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UltLogInitializer.initDebug(this, true, TagSettings(
                shouldLogFileNameAndLineNr = true,
                shouldLogClassName = true,
                shouldLogMethodName = true))

        UltLog.e("12345")
        UltLog.e(Exception())
    }
}