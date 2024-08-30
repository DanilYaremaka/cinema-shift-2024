package com.example.cinema_shift_2024.schedule.data.converter

import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule
import com.example.shared.data.model.schedule.Schedule

class ScheduleConverter {

    fun convert(model: Schedule): FilmSchedule =
        FilmSchedule(
            date = model.date,
            seances = model.seances
        )
}