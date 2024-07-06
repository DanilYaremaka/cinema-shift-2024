package com.example.cinema_shift_2024.posters.domain.entity
import kotlinx.serialization.Serializable

@Serializable
data class Film(
    val id: String,
    val name: String,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: String? = null
)
