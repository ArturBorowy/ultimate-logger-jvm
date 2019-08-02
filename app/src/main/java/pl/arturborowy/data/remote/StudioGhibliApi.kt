package pl.arturborowy.data.remote

import io.reactivex.Single
import pl.arturborowy.data.model.Film
import retrofit2.http.GET

interface StudioGhibliApi {

    companion object {
        const val BASE_URL = "https://ghibliapi.herokuapp.com/"
    }

    @GET("films")
    fun getFilms(): Single<List<Film>>
}