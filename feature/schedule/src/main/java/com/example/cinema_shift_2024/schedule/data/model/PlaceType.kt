package com.example.cinema_shift_2024.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
enum class PlaceType {
    BLOCKED,
    ECONOM,
    COMFORT
}