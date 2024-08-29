package com.example.cinema_shift_2024.selection.domain.entity

import com.example.shared.data.model.schedule.PlaceType

data class Seat(
    val column: Int,
    val row: Int,
    val price: Int,
    val placeType: PlaceType
)
