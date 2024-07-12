package com.example.cinema_shift_2024.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val date: String,
    val seances: List<ScheduleSeance>
)