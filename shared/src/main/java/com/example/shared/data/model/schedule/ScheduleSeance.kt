package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleSeance(
    val time: String,
    val hall: Hall,
    val payedTickets: List<Ticket>
)
