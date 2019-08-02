package pl.arturborowy.util.extensionfunctions

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 *  Extension method to provide simpler access to {@link ContextCompat#getColor(int)}
 *  from a [Fragment].
 */
fun Fragment.getColorCompat(color: Int) = context?.getColorCompat(color)

/**
 * Extension method to provide simpler access to {@link ContextCompat#getDrawableCompat(int)}
 * from a [Fragment].
 */
fun Fragment.getDrawableCompat(drawableResId: Int) =
        context?.getDrawableCompat(drawableResId)

/**
 * Extension method to provide hide keyboard for [Fragment].
 */
fun Fragment.hideSoftKeyboard() = activity?.hideKeyboard()

/**
 * Extension method to be used as the body for functions that are not yet implemented, which will
 * display a [Toast] with the specified [message].
 */
fun Fragment.NOT_IMPL(message: String = "This action is not implemented yet!") {
    TOAST(message)
}

/**
 * Extension method used to display a [Toast] message to the user.
 */
fun Fragment.TOAST(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}

/**
 * Extension method used to display a [Toast] message to the user.
 */
fun Fragment.TOAST(messageResId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, messageResId, duration).show()
}