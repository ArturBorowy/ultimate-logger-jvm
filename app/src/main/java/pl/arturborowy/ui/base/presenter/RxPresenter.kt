package pl.arturborowy.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import pl.arturborowy.ui.base.view.MvpView

abstract class RxPresenter<ViewT : MvpView> : MvpViewPresenter<ViewT>() {

    private val compositeDisposable = CompositeDisposable()

    override fun beforeViewDetached() {
        super.beforeViewDetached()

        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    fun Disposable.addToSubs() = addTo(compositeDisposable)
}