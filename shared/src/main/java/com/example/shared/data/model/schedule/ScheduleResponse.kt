package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleResponse(
    val success: Boolean,
    val reason: String? = null,
    val schedules: List<Schedule>
)
