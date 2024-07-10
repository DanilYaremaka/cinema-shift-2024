package com.example.cinema_shift_2024.details.domain.usecase

import com.example.cinema_shift_2024.details.domain.entity.Details
import com.example.cinema_shift_2024.details.domain.repository.DetailsRepository

class GetDetailsUseCase(private val repository: DetailsRepository) {

    operator suspend fun invoke(filmId: String): Details = repository.getDetails(filmId)
}