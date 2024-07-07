package com.example.cinema_shift_2024.details.domain.entity

import com.example.cinema_shift_2024.common.data.model.UserRatings

data class Details(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<String>,
    val directors: List<String>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: String? = null
)
