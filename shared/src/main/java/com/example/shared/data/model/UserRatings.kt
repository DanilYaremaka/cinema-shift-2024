package com.example.shared.data.model
import kotlinx.serialization.Serializable

@Serializable
data class UserRatings(
    val kinopoisk: String,
    val imdb: String
)
