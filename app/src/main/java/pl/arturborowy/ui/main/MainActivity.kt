package pl.arturborowy.ui.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import pl.arturborowy.R
import pl.arturborowy.data.model.Film
import pl.arturborowy.ui.base.activity.BaseActivity
import pl.arturborowy.ui.main.adapter.FilmsAdapter
import pl.arturborowy.util.extensionfunctions.defaultInit
import pl.arturborowy.util.extensionfunctions.makeGone
import pl.arturborowy.util.extensionfunctions.makeVisible
import javax.inject.Inject

class MainActivity : BaseActivity<MainMvpView, MainPresenter>(), MainMvpView {

    @Inject
    override lateinit var presenter: MainPresenter

    @Inject
    lateinit var filmsAdapter: FilmsAdapter

    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent?.inject(this)
        presenter.attachView(this)
    }

    override fun setUpView() {
        filmsAdapter.setOnFilmClickListener { presenter.onFilmClick(it) }
        filmsRecyclerViewMainActivity.defaultInit(filmsAdapter)
    }

    override fun updateFilmsList(films: List<Film>) = filmsAdapter.updateItems(films)

    override fun showProgress() = loadingProgressBarMainActivity.makeVisible()

    override fun hideProgress() = loadingProgressBarMainActivity.makeGone()
}