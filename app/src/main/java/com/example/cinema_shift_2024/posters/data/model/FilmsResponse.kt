package com.example.cinema_shift_2024.posters.data.model
import com.example.cinema_shift_2024.common.data.model.FilmModel
import kotlinx.serialization.Serializable

@Serializable
data class FilmsResponse(
    val success: Boolean,
    val reason: String? = null,
    val films: List<FilmModel>
)
