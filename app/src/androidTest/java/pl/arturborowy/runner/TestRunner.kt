package pl.arturborowy.runner

import android.app.Application
import android.content.Context
import io.appflate.restmock.android.RESTMockTestRunner
import pl.arturborowy.App

class TestRunner : RESTMockTestRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, App::class.java.name, context)
    }

}
