package pl.arturborowy.ui.main

import pl.arturborowy.data.model.Film
import pl.arturborowy.ui.base.view.MvpView

interface MainMvpView : MvpView {

    fun showProgress()

    fun hideProgress()

    fun updateFilmsList(films: List<Film>)
}