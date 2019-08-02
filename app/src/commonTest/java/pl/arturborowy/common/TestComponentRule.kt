package pl.arturborowy.common

import android.content.Context
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import pl.arturborowy.App
import pl.arturborowy.common.injection.component.DaggerTestComponent
import pl.arturborowy.common.injection.component.TestComponent
import pl.arturborowy.common.injection.module.ApplicationTestModule

/**
 * Test rule that creates and sets a Dagger TestComponent into the application overriding the
 * existing application component.
 * Use this rule in your test case in order for the app to use mock dependencies.
 * It also exposes some of the dependencies so they can be easily accessed from the tests, e.g. to
 * stub mocks etc.
 */
class TestComponentRule(val context: Context) : TestRule {

    val testComponent: TestComponent

    init {
        val application = App.get(context)
        testComponent = DaggerTestComponent.builder()
                .applicationTestModule(ApplicationTestModule(application))
                .build()
    }

    override fun apply(base: Statement, description: Description): Statement =
            object : Statement() {
                @Throws(Throwable::class)
                override fun evaluate() {
                    val application = App.get(context)
                    application.component = testComponent
                    base.evaluate()
                }
            }
}