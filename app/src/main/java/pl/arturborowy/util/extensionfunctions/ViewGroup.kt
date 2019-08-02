package pl.arturborowy.util.extensionfunctions

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Extension method to simplify view inflating and binding inside a [ViewGroup].
 *
 * e.g.
 * This:
 *<code>
 *     binding = bind(R.layout.widget_card)
 *</code>
 *
 * Will replace this:
 *<code>
 *     binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.widget_card, this, true)
 *</code>
 */
fun <ViewDataBindingT : ViewDataBinding> ViewGroup.bind(@LayoutRes layoutId: Int): ViewDataBindingT =
        DataBindingUtil.inflate(getLayoutInflater(), layoutId, this, true)