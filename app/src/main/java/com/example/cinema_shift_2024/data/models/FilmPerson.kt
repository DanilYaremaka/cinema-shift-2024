package com.example.cinema_shift_2024.data.models
import kotlinx.serialization.Serializable

@Serializable
data class FilmPerson(
    val id: String,
    val professions: List<Professions>,
    val fullName: String
)
