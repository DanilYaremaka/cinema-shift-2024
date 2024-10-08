package com.example.cinema_shift_2024.feature.posters.data.network

import com.example.cinema_shift_2024.feature.posters.data.model.FilmsResponse
import retrofit2.http.GET

interface PostersApi {

    @GET("/cinema/today")
    suspend fun getFilmsList(): FilmsResponse
}