package com.example.cinema_shift_2024.schedule.domain.entity

import com.example.shared.data.model.schedule.ScheduleSeance

data class FilmSchedule(
    val date: String,
    val seances: List<ScheduleSeance>
)
