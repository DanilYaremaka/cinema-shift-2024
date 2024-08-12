package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class FilmSeance(
    val date: String,
    val time: String
)
