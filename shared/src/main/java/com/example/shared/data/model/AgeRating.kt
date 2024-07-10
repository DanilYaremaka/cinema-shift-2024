package com.example.shared.data.model

import kotlinx.serialization.Serializable

@Serializable
enum class AgeRating {
    G,
    PG,
    PG13,
    R,
    NC17
}