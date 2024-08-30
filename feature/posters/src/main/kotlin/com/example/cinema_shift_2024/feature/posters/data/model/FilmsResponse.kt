package com.example.cinema_shift_2024.feature.posters.data.model
import com.example.shared.data.model.film.FilmModel
import kotlinx.serialization.Serializable

@Serializable
data class FilmsResponse(
    val success: Boolean,
    val reason: String? = null,
    val films: List<FilmModel>
)
