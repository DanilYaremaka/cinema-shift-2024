package com.example.cinema_shift_2024.schedule.domain.repository

import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule

interface ScheduleRepository {

    suspend fun getWeekSchedule(filmId: String): List<FilmSchedule>
}