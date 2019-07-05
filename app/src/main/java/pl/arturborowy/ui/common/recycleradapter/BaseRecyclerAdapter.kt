package pl.arturborowy.ui.common.recycleradapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.arturborowy.ui.common.LayoutResIdNeedy
import pl.arturborowy.util.ViewInflater

abstract class BaseRecyclerAdapter<ItemT>(private val viewInflater: ViewInflater,
                                          private var items: Collection<ItemT> = listOf()) :
        RecyclerView.Adapter<ViewHolder<ItemT>>(), LayoutResIdNeedy {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ItemT> {
        val view = viewInflater.inflate(getLayoutResId(), parent)
        return ViewHolder(view,
                bind = { item: ItemT, position: Int -> bindViewHolder(view, item, position) })
    }

    override fun onBindViewHolder(holder: ViewHolder<ItemT>, position: Int) =
            holder.bind(items.elementAt(position), position)

    override fun getItemCount() = items.size

    fun updateItems(items: Collection<ItemT>) {
        this.items = items
        notifyDataSetChanged()
    }

    abstract fun bindViewHolder(itemView: View, item: ItemT, position: Int)
}