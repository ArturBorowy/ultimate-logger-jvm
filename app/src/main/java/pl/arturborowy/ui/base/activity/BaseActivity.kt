package pl.arturborowy.ui.base.activity

import android.os.Bundle
import pl.arturborowy.ui.base.presenter.BasePresenter
import pl.arturborowy.ui.base.view.BaseView
import pl.arturborowy.ui.base.view.MvpView

/**
 * Abstract activity that every other Activity in this application must implement.
 */
abstract class BaseActivity<ViewT : MvpView, PresenterT : BasePresenter<ViewT>> :
        InjectionActivity(), BaseView<ViewT, PresenterT> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}