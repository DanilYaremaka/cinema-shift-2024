package com.example.cinema_shift_2024.data.models

data class FilmResponse(
    val success: Boolean,
    val reason: String?,
    val film: Film
)
