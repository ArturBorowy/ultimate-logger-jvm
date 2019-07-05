package pl.arturborowy.ui.main.adapter

import android.view.View
import kotlinx.android.synthetic.main.item_film.view.*
import pl.arturborowy.R
import pl.arturborowy.data.model.Film
import pl.arturborowy.ui.common.recycleradapter.BaseRecyclerAdapter
import pl.arturborowy.util.ViewInflater

class FilmsAdapter(viewInflater: ViewInflater) : BaseRecyclerAdapter<Film>(viewInflater) {

    private var onFilmClickAction: (Film) -> Unit = {}

    override fun getLayoutResId() = R.layout.item_film

    override fun bindViewHolder(itemView: View, item: Film, position: Int) =
            itemView.run {
                titleTvFilmItem.text = item.title
                yearTvFilmItem.text = item.releaseDate
                descTvFilmItem.text = item.description

                setOnClickListener { onFilmClickAction(item) }
            }

    fun setOnFilmClickListener(onFilmClickAction: (Film) -> Unit) {
        this.onFilmClickAction = onFilmClickAction
    }
}
