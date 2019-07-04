package pl.arturborowy.ui.base.presenter

import pl.arturborowy.ui.base.view.MvpView

abstract class MvpViewPresenter<ViewT : MvpView> {

    protected val view: ViewT
        get() = internalView ?: throw MvpViewNotAttachedException()

    private var internalView: ViewT? = null

    fun attachView(mvpView: ViewT) {
        internalView = mvpView
        onViewAttached()
    }

    /**
     * Method where we can init everything we need in presenter on start.
     */
    open fun onViewAttached() = view.setUpView()

    fun detachView() {
        beforeViewDetached()
        internalView = null
    }

    open fun beforeViewDetached() {}

    private class MvpViewNotAttachedException internal constructor() :
            RuntimeException("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter")
}
