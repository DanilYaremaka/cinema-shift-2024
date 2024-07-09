package com.example.cinema_shift_2024.details.data.network

import com.example.cinema_shift_2024.details.data.model.FilmResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {

    @GET("/cinema/film/{filmId}")
    suspend fun getFilmById(@Path("filmId") filmId: String): FilmResponse
}