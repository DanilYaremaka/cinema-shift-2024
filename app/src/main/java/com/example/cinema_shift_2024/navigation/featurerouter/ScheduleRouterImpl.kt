package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.schedule.presentation.ScheduleRouter
import com.example.cinema_shift_2024.selection.SelectionRoute
import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ScheduleRouterImpl(
    private val router: GlobalRouter
): ScheduleRouter {

    override fun goBack() {
        router.pop()
    }

    override fun openSelection(seanceInfo: SeanceInfo) {
        router.open(SelectionRoute(Json.encodeToString(seanceInfo)))
    }
}