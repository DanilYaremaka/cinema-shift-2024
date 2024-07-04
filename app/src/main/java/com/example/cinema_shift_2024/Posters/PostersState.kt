package com.example.cinema_shift_2024.Posters

import com.example.cinema_shift_2024.data.models.Film

sealed interface PostersState {

    data object Initial : PostersState
    data object Loading : PostersState
    data class Content(val films: List<Film>) : PostersState
    data class Failure(val message: String) : PostersState
}