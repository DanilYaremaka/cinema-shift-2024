package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.details.presentation.DetailsRouter
import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.schedule.ScheduleRoute

class DetailsRouterImpl(private val router: GlobalRouter): DetailsRouter {

    override fun goBack() {
        router.pop()
    }

    override fun openSchedule(filmId: String) {
        router.open(ScheduleRoute(filmId))
    }
}