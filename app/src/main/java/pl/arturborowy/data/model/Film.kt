package pl.arturborowy.data.model

import com.squareup.moshi.Json

data class Film(
        val id: String,

        val title: String,

        @Json(name = "release_date")
        val releaseDate: String,

        val species: List<String>,

        val director: String,

        val description: String,

        val producer: String,

        val vehicles: List<String>,

        val locations: List<String>,

        @Json(name = "rt_score")
        val rtScore: String,

        val people: List<String>,

        val url: String
)
