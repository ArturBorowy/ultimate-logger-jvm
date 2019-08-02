package pl.arturborowy.ui.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.arturborowy.injection.component.ActivityComponent
import pl.arturborowy.injection.module.ActivityModule
import pl.arturborowy.ui.base.view.ConfigPersistentComponentView

/**
 * Provides the following functionality:
 * - Handles creation of Dagger components and makes sure that instances of
 * ConfigPersistentComponent are kept across configuration changes.
 */
abstract class InjectionActivity : AppCompatActivity(), ConfigPersistentComponentView {

    override var viewId = 0L

    protected var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = getActivityComponent(savedInstanceState)
    }

    private fun getActivityComponent(savedInstanceState: Bundle?) =
            getConfigPersistentComponent(this, savedInstanceState)
                    ?.activityComponent(ActivityModule(this))

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveViewId(outState)
    }

    override fun onDestroy() {
        removeConfigPersistentComponentIfNeedTo(isChangingConfigurations)
        super.onDestroy()
    }
}