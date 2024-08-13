package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class SeanceInfo(
    val date: String,
    val time: String,
    val payedTickets: List<Ticket>,
    val hall: Hall
)
