package com.example.cinema_shift_2024.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("cinema/today")
    suspend fun getList()

    @GET("cinema/film/{filmId}")
    suspend fun getFilmById(@Path("filmId") filmId: String)

    @GET("cinema/film/{filmId}/schedule")
    suspend fun getFilmSchedule(@Path("filmId") filmId: String)
}