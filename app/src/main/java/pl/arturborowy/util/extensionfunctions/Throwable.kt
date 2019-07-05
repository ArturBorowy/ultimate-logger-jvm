package pl.arturborowy.util.extensionfunctions

import retrofit2.HttpException

/**
 * Returns true if the Throwable is an instance of RetrofitError with an
 * http status code equals to the given one.
 */
fun Throwable.isHttpStatusCode(statusCode: Int) =
        this is HttpException && code() == statusCode