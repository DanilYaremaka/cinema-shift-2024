package com.example.cinema_shift_2024.data.models
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Long,
    val code: String,
    val code2: String,
    val name: String
)
