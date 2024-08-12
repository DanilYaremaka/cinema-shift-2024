package com.example.cinema_shift_2024.feature.posters.domain.entity

import com.example.shared.data.model.film.UserRatings

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
