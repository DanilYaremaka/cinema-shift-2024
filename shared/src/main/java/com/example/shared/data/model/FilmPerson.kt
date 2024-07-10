package com.example.shared.data.model
import kotlinx.serialization.Serializable

@Serializable
data class FilmPerson(
    val id: String,
    val professions: List<Professions>,
    val fullName: String
)
