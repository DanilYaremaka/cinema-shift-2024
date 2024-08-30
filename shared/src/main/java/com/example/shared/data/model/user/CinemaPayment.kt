package com.example.shared.data.model.user

import com.example.shared.data.model.schedule.FilmSeance
import com.example.shared.data.model.schedule.SeatNumbers

data class CinemaPayment(
    val filmId: String,
    val person: PersonInfo,
    val debitCard: DebitCard,
    val seance: FilmSeance,
    val tickets: List<SeatNumbers>
)
