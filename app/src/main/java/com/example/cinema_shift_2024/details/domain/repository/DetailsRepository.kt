package com.example.cinema_shift_2024.details.domain.repository

import com.example.cinema_shift_2024.details.domain.entity.Details

interface DetailsRepository {

    fun getDetails(filmId: String): Details
}