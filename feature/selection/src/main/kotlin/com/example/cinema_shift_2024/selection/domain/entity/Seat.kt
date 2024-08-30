package com.example.cinema_shift_2024.selection.domain.entity

import com.example.shared.data.model.schedule.PlaceType
import com.example.shared.data.model.schedule.SeatNumbers

data class Seat(
    val seatNumbers: SeatNumbers,
    val price: Int,
    val placeType: PlaceType
)
