package com.example.cinema_shift_2024.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleSeance(
    val time: String,
    val hall: Hall,
    val payedTickets: List<Ticket>
)
