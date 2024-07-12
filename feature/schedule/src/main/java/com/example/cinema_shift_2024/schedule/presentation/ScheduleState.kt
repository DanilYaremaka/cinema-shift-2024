package com.example.cinema_shift_2024.schedule.presentation

import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule

interface ScheduleState {

    data object Initial: ScheduleState
    data object Loading: ScheduleState
    data class Failure(val message: String?): ScheduleState
    data class Content(val schedule: List<FilmSchedule>): ScheduleState
}