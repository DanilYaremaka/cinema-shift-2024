package com.example.cinema_shift_2024.data.models

data class FilmsResponse(
    val success: Boolean,
    val reason: String?,
    val films: List<Film>
)
