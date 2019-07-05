package pl.arturborowy.util.extensionfunctions

import android.app.Activity
import android.graphics.Rect
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Extension method to provide hide keyboard for [Activity].
 */
fun Activity.hideKeyboard() {
    currentFocus?.let { getInputMethodManager().hideSoftInputFromWindow(it.windowToken, 0) }
}

/**
 * Return whether Keyboard is currently visible on screen or not.
 *
 * @return true if keyboard is visible.
 */
fun Activity.isKeyboardVisible(): Boolean {
    val r = Rect()

    //r will be populated with the coordinates of your view that area still visible.
    window.decorView.getWindowVisibleDisplayFrame(r)

    //get screen height and calculate the difference with the usable area from the r
    val height = getDisplaySize().y
    val diff = height - r.bottom

    // If the difference is not 0 we assume that the keyboard is currently visible.
    return diff != 0
}

fun <ViewDataBindingT : ViewDataBinding> Activity.bind(@LayoutRes layoutId: Int): ViewDataBindingT =
        DataBindingUtil.setContentView(this, layoutId)