package com.example.cinema_shift_2024.details.presentation

import com.example.cinema_shift_2024.details.domain.entity.Details

interface DetailsState {

    data object Initial : DetailsState
    data object Loading : DetailsState
    data class Failure(val message: String?) : DetailsState
    data class Content(val details: Details) : DetailsState
}
