package com.example.cinema_shift_2024.schedule.data.network

import com.example.shared.data.model.schedule.ScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleApi {

    @GET("/cinema/film/{filmId}/schedule")
    suspend fun getFilmSchedule(@Path("filmId") filmId: String): ScheduleResponse
}