package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class Hall(
    val name: HallName,
    val places: List<List<Place>>
)
