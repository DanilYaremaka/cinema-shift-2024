package com.example.cinema_shift_2024.posters.presentation

import com.example.cinema_shift_2024.posters.domain.entity.Film

sealed interface PostersState {

    data object Initial : PostersState
    data object Loading : PostersState
    data class Content(val films: List<Film>) : PostersState
    data class Failure(val message: String?) : PostersState
}