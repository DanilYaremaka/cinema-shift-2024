package com.example.shared.data.model.user

import com.example.shared.data.model.schedule.SeatNumbers
import com.example.shared.data.model.schedule.TicketSeance

data class CinemaPayment(
    val filmId: String,
    val person: PersonInfo,
    val debitCard: DebitCard,
    val seance: TicketSeance,
    val tickets: List<SeatNumbers>
)
