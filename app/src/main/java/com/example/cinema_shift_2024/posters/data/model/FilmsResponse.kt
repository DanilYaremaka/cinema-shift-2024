package com.example.cinema_shift_2024.posters.data.model
import kotlinx.serialization.Serializable

@Serializable
data class FilmsResponse(
    val success: Boolean,
    val reason: String? = null,
    val films: List<FilmModel>
)
