package pl.arturborowy.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.logger.TagSettings
import pl.arturborowy.logger.UltLog
import pl.arturborowy.logger.UltLogInitializer

class LoggingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UltLogInitializer.initDebug(this, true, TagSettings(shouldLogFileName = true,
                shouldLogClassName = true, shouldLogMethodName = true, shouldLogLineNr = true))

        UltLog.e("12345")
    }
}