package com.example.cinema_shift_2024.details.data.model

import com.example.shared.data.model.film.FilmModel
import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
    val success: Boolean,
    val reason: String? = null,
    val film: FilmModel
)
