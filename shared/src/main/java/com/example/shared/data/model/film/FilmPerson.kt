package com.example.shared.data.model.film
import kotlinx.serialization.Serializable

@Serializable
data class FilmPerson(
    val id: String,
    val professions: List<Professions>,
    val fullName: String
)
