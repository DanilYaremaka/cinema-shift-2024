package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.schedule.presentation.ScheduleRouter

class ScheduleRouterImpl(
    private val router: GlobalRouter
): ScheduleRouter {

    override fun goBack() {
        router.pop()
    }
}