package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val date: String,
    val seances: List<ScheduleSeance>
)