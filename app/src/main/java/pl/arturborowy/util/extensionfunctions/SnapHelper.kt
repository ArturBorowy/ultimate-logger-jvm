package pl.arturborowy.util.extensionfunctions

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import pl.arturborowy.util.DimensionsSequence

/**
 * Provide the ability to snap to a specified [position] in the specified [recyclerView]
 * using [SnapHelper].
 */
fun SnapHelper.snapToPosition(recyclerView: RecyclerView, position: Int) {
    recyclerView.apply {
        val view = findViewHolderForAdapterPosition(position)?.itemView
        val snapPositions = view?.let {
            calculateDistanceToFinalSnap(layoutManager as RecyclerView.LayoutManager, it)
        }

        snapPositions?.let {
            smoothScrollBy(it[DimensionsSequence.X_POSITION], it[DimensionsSequence.Y_POSITION])
        }
    }
}