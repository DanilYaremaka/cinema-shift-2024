package com.example.cinema_shift_2024.schedule.data.repository

import com.example.cinema_shift_2024.schedule.data.converter.ScheduleConverter
import com.example.cinema_shift_2024.schedule.data.network.ScheduleApi
import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule
import com.example.cinema_shift_2024.schedule.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl(
    private val api: ScheduleApi,
    private val converter: ScheduleConverter
): ScheduleRepository {

    override suspend fun getWeekSchedule(filmId: String): List<FilmSchedule> {
        val response = api.getFilmSchedule(filmId)
        return response.schedules.map { converter.convert(it) }
    }
}