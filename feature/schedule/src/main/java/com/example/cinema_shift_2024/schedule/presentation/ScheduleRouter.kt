package com.example.cinema_shift_2024.schedule.presentation

import com.example.shared.data.model.schedule.SeanceInfo

interface ScheduleRouter {

    fun goBack()

    fun openSelection(seanceInfo: SeanceInfo)
}