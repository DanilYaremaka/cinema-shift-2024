package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val filmId: String,
    val row: Int,
    val column: Int,
    val seance: FilmSeance,
    val phone: String
)
