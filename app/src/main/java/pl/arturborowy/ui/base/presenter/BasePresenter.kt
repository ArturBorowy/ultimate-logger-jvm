package pl.arturborowy.ui.base.presenter

import pl.arturborowy.ui.base.view.MvpView

/**
 * Every presenter in the app must extend this class.
 */
abstract class BasePresenter<ViewT : MvpView> : RxPresenter<ViewT>()

