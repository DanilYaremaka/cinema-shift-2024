package com.example.cinema_shift_2024.data.models
import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
    val success: Boolean,
    val reason: String? = null,
    val film: Film
)
