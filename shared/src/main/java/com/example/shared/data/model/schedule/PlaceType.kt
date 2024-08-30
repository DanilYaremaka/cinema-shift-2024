package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
enum class PlaceType {
    BLOCKED,
    ECONOM,
    COMFORT
}