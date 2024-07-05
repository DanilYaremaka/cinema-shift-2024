package com.example.cinema_shift_2024.data.models
import kotlinx.serialization.Serializable

@Serializable
data class FilmsResponse(
    val success: Boolean,
    val reason: String? = null,
    val films: List<Film>
)
