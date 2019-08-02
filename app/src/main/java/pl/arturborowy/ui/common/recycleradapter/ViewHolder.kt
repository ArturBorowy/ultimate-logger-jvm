package pl.arturborowy.ui.common.recycleradapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewHolder<ItemT>(itemView: View, val bind: (item: ItemT, position: Int) -> Unit) :
        RecyclerView.ViewHolder(itemView)