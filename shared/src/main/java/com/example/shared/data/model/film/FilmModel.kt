package com.example.shared.data.model.film
import kotlinx.serialization.Serializable

@Serializable
data class FilmModel(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<FilmPerson>,
    val directors: List<FilmPerson>,
    val runtime: Int,
    val ageRating: AgeRating,
    val genres: List<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: Country? = null
)
