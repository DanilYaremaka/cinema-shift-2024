package com.example.cinema_shift_2024.schedule.domain.entity

import com.example.cinema_shift_2024.schedule.shared.data.model.HallName

data class Seance(
    val time: String,
    val hall: HallName
)
