package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class Place(
    val price: Int,
    val type: PlaceType
)
