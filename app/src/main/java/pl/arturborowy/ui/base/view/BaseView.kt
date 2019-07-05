package pl.arturborowy.ui.base.view

import pl.arturborowy.ui.base.presenter.BasePresenter
import pl.arturborowy.ui.common.LayoutResIdNeedy

interface BaseView<ViewT : MvpView, PresenterT : BasePresenter<ViewT>> : LayoutResIdNeedy, MvpView {

    val presenter: PresenterT
}