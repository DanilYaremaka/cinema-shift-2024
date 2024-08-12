package com.example.shared.data.model.film
import kotlinx.serialization.Serializable

@Serializable
data class UserRatings(
    val kinopoisk: String,
    val imdb: String
)
