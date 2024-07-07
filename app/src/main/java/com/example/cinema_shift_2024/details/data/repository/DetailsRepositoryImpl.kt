package com.example.cinema_shift_2024.details.data.repository

import com.example.cinema_shift_2024.details.data.converter.DetailsConverter
import com.example.cinema_shift_2024.details.data.network.DetailsApi
import com.example.cinema_shift_2024.details.domain.entity.Details
import com.example.cinema_shift_2024.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val detailsApi: DetailsApi,
    private val converter: DetailsConverter
): DetailsRepository {

    override suspend fun getDetails(filmId: String): Details {
        val response = detailsApi.getFilmById(filmId)
        return converter.convert(response.film)
    }
}