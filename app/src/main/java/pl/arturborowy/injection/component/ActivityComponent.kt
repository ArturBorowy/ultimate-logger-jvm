package pl.arturborowy.injection.component

import dagger.Subcomponent
import pl.arturborowy.injection.PerActivity
import pl.arturborowy.injection.module.ActivityModule
import pl.arturborowy.ui.base.activity.BaseActivity
import pl.arturborowy.ui.base.presenter.BasePresenter
import pl.arturborowy.ui.base.view.MvpView
import pl.arturborowy.ui.main.MainActivity

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity<MvpView, BasePresenter<MvpView>>)

    fun inject(mainActivity: MainActivity)
}
