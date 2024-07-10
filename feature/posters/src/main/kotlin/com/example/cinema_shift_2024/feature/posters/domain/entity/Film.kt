package com.example.cinema_shift_2024.feature.posters.domain.entity

data class Film(
    val id: String,
    val name: String,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: com.example.shared.data.model.UserRatings,
    val img: String,
    val country: String? = null
)
