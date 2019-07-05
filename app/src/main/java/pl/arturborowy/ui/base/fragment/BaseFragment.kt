package pl.arturborowy.ui.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.arturborowy.ui.base.presenter.BasePresenter
import pl.arturborowy.ui.base.view.BaseView
import pl.arturborowy.ui.base.view.MvpView

/**
 * Abstract Fragment that every other Fragment in this application must implement.
 */
abstract class BaseFragment<ViewT : MvpView, PresenterT : BasePresenter<ViewT>> :
        InjectionFragment(), BaseView<ViewT, PresenterT> {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(getLayoutResId(), container, false)

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}