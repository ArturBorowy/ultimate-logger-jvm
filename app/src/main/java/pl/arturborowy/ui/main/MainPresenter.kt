package pl.arturborowy.ui.main

import io.reactivex.rxkotlin.subscribeBy
import pl.arturborowy.data.model.Film
import pl.arturborowy.data.remote.StudioGhibliApi
import pl.arturborowy.injection.ConfigPersistent
import pl.arturborowy.ui.base.presenter.BasePresenter
import pl.arturborowy.util.extensionfunctions.toUiInteraction
import timber.log.Timber
import javax.inject.Inject

@ConfigPersistent
class MainPresenter
@Inject
constructor(private val studioGhibliApi: StudioGhibliApi) : BasePresenter<MainMvpView>() {

    override fun onViewAttached() {
        super.onViewAttached()
        showFilmsOnList()
    }

    private fun showFilmsOnList() {
        view.showProgress()

        studioGhibliApi.getFilms()
                .toUiInteraction()
                .subscribeBy(
                        onSuccess = {
                            view.updateFilmsList(it)

                            view.hideProgress()
                        },
                        onError = { handleApiCommunicationThrowable(it) })
                .addToSubs()
    }

    private fun handleApiCommunicationThrowable(throwable: Throwable) {
        Timber.e(throwable)
        view.hideProgress()
    }

    fun onFilmClick(film: Film) {
        TODO()
    }
}