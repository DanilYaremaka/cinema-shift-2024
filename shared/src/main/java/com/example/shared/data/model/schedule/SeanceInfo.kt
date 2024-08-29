package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class SeanceInfo(
    val filmId: String,
    val filmSeance: FilmSeance,
    val payedTickets: List<Ticket>,
    val hall: Hall
)
