package com.example.cinema_shift_2024.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleResponse(
    val success: Boolean,
    val reason: String? = null,
    val schedules: List<Schedule>
)
