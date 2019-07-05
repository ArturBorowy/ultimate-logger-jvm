package pl.arturborowy.util.extensionfunctions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.arturborowy.ui.common.recycleradapter.BaseRecyclerAdapter

fun RecyclerView.defaultInit(adapter: BaseRecyclerAdapter<*>) {
    layoutManager = LinearLayoutManager(this.context)
    this.adapter = adapter
}