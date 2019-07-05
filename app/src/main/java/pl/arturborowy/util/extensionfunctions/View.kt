package pl.arturborowy.util.extensionfunctions

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import pl.arturborowy.util.DimensionsSequence

/**
 * Extension method to provide simpler access to {@link View#getResources()#getString(int)}.
 */
fun View.getString(stringResId: Int): String = resources.getString(stringResId)

/**
 * Extension method to provide show keyboard for View.
 */
fun View.showKeyboard() {
    requestFocus()
    context.getInputMethodManager().showSoftInput(this, 0)
}

/**
 * Extension method to provide hide keyboard for [View].
 */
fun View.hideKeyboard() {
    context.getInputMethodManager().hideSoftInputFromWindow(windowToken, 0)
}

/**
 * Extension method to provide quicker access to the [LayoutInflater] from a [View].
 */
fun View.getLayoutInflater() = context.getLayoutInflater()

/**
 * Extension method use to display a [Snackbar] message to the user.
 */
fun View.displaySnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val snackbar = Snackbar.make(this, message, duration)
    snackbar.show()
    return snackbar
}

/**
 * Extension method use to display a [Snackbar] message to the user.
 */
fun View.displaySnackbar(messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT) =
        displaySnackbar(getString(messageResId), duration)

/**
 * Extension method to return the view location on screen as a [Point].
 */
fun View.locationOnScreen(): Point {
    val location = IntArray(DimensionsSequence.LENGTH)
    getLocationOnScreen(location)
    return Point(location[DimensionsSequence.X_POSITION], location[DimensionsSequence.Y_POSITION])
}

/**
 * Extension method to return the view location in window as a [Point].
 */
fun View.locationInWindow(): Point {
    val location = IntArray(DimensionsSequence.LENGTH)
    getLocationInWindow(location)
    return Point(location[DimensionsSequence.X_POSITION], location[DimensionsSequence.Y_POSITION])
}

/**
 * Method used to easily retrieve display size from [View].
 */
fun View.getDisplaySize() = context.getDisplaySize()

fun View.makeGone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.makeVisible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.makeInvisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

/**
 * Extension method to set width for View.
 */
fun View.setWidth(value: Int) {
    layoutParams.width = value
}

/**
 * Extension method to set height for View.
 */
fun View.setHeight(value: Int) {
    layoutParams.height = value
}

/**
 * Extension method to simplify view binding.
 */
fun <ViewDataBindingT : ViewDataBinding> View.bind(): ViewDataBindingT? =
        DataBindingUtil.bind(this)