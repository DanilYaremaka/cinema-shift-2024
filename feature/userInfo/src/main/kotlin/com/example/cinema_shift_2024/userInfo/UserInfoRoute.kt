package com.example.cinema_shift_2024.userInfo

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoRoute(
    val seanceInfo: String,
    val selectedSeats: String
)