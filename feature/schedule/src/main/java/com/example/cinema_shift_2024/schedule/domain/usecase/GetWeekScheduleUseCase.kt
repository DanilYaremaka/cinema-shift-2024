package com.example.cinema_shift_2024.schedule.domain.usecase

import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule
import com.example.cinema_shift_2024.schedule.domain.repository.ScheduleRepository

class GetWeekScheduleUseCase(private val repository: ScheduleRepository) {

    suspend operator fun invoke(filmId: String): List<FilmSchedule> =
        repository.getWeekSchedule(filmId)
}