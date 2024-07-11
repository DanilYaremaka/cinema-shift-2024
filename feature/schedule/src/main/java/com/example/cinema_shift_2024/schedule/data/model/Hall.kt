package com.example.cinema_shift_2024.schedule.data.model

import com.example.cinema_shift_2024.schedule.shared.data.model.HallName
import kotlinx.serialization.Serializable

@Serializable
data class Hall(
    val name: HallName,
    val places: List<List<Place>>
)
