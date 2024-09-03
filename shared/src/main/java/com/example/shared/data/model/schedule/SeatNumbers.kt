package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class SeatNumbers(
    val row: Int,
    val column: Int
)
