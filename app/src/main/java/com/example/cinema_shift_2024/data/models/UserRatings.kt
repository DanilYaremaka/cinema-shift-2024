package com.example.cinema_shift_2024.data.models
import kotlinx.serialization.Serializable

@Serializable
data class UserRatings(
    val kinopoisk: String,
    val imdb: String
)
