package com.example.cinema_shift_2024.data.network

import com.example.cinema_shift_2024.data.models.FilmResponse
import com.example.cinema_shift_2024.data.models.FilmsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("cinema/today")
    suspend fun getFilmsList(): FilmsResponse

    @GET("cinema/film/{filmId}")
    suspend fun getFilmById(@Path("filmId") filmId: String): FilmResponse

    @GET("cinema/film/{filmId}/schedule")
    suspend fun getFilmSchedule(@Path("filmId") filmId: String)

    @GET("static/images/cinema/{image}")
    suspend fun getImage(@Path("image") image: String)
}