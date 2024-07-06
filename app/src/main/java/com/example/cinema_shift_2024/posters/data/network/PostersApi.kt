package com.example.cinema_shift_2024.posters.data.network

import com.example.cinema_shift_2024.posters.data.models.FilmsResponse
import retrofit2.http.GET

interface PostersApi {

    @GET("cinema/today")
    suspend fun getFilmsList(): FilmsResponse

}