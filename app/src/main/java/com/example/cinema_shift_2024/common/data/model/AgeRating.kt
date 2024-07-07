package com.example.cinema_shift_2024.common.data.model

import kotlinx.serialization.Serializable

@Serializable
enum class AgeRating {
    G,
    PG,
    PG13,
    R,
    NC17
}