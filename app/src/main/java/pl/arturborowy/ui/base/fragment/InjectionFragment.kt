package pl.arturborowy.ui.base.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import pl.arturborowy.injection.component.FragmentComponent
import pl.arturborowy.injection.module.FragmentModule
import pl.arturborowy.ui.base.view.ConfigPersistentComponentView

/**
 * Provides the following functionality:
 * - Handles creation of Dagger components and makes sure that instances of
 * ConfigPersistentComponent are kept across configuration changes.
 */
abstract class InjectionFragment : Fragment(), ConfigPersistentComponentView {

    override var viewId = 0L

    protected var fragmentComponent: FragmentComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = getFragmentComponent(savedInstanceState)
    }

    private fun getFragmentComponent(savedInstanceState: Bundle?) =
            getConfigPersistentComponent(context, savedInstanceState)
                    ?.fragmentComponent(FragmentModule(this))

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveViewId(outState)
    }

    override fun onDestroy() {
        activity?.isChangingConfigurations?.let { removeConfigPersistentComponentIfNeedTo(it) }
        super.onDestroy()
    }
}