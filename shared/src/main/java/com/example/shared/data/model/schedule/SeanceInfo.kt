package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class SeanceInfo(
    val filmId: String,
    val ticketSeance: TicketSeance,
    val payedTickets: List<Ticket>,
    val hall: Hall
)
