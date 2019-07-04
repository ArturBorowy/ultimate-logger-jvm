package pl.arturborowy.injection.component

import dagger.Component
import pl.arturborowy.injection.ConfigPersistent
import pl.arturborowy.injection.module.ActivityModule
import pl.arturborowy.injection.module.FragmentModule
import pl.arturborowy.ui.base.activity.BaseActivity
import pl.arturborowy.ui.base.fragment.BaseFragment

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't
 * be destroy during configuration changes. Check [BaseActivity] and [BaseFragment] to
 * see how this components survives configuration changes.
 * Use the [ConfigPersistent] scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = [AppComponent::class])
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent

}
