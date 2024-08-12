package com.example.shared.data.model.film

import kotlinx.serialization.Serializable

@Serializable
enum class AgeRating {
    G,
    PG,
    PG13,
    R,
    NC17
}