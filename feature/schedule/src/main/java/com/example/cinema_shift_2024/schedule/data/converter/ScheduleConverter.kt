package com.example.cinema_shift_2024.schedule.data.converter

import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule
import com.example.cinema_shift_2024.schedule.domain.entity.Seance
import com.example.shared.data.model.schedule.Schedule
import com.example.shared.data.model.schedule.ScheduleSeance

class ScheduleConverter {

    fun convert(model: Schedule): FilmSchedule =
        FilmSchedule(
            date = model.date,
            seances = convertSeances(model.seances)
        )

    private fun convertSeances(modelList: List<ScheduleSeance>): List<Seance> =
        modelList.map {
            Seance(
                it.time,
                it.hall.name
            )
        }
}