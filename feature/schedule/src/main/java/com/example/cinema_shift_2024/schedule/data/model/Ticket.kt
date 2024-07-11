package com.example.cinema_shift_2024.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val filmId: String,
    val row: Int,
    val column: Int,
    val seance: FilmSeance,
    val phone: String
)
