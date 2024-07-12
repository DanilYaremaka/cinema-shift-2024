package com.example.cinema_shift_2024.schedule.domain.entity

data class FilmSchedule(
    val date: String,
    val seances: List<Seance>
)
