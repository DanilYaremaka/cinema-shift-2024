package com.example.cinema_shift_2024.common
import kotlinx.serialization.Serializable

@Serializable
data class UserRatings(
    val kinopoisk: String,
    val imdb: String
)
