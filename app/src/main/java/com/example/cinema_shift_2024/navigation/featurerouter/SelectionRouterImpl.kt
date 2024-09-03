package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.selection.presentation.SelectionRouter
import com.example.cinema_shift_2024.userInfo.UserInfoRoute
import com.example.shared.data.model.schedule.SeanceInfo
import com.example.shared.data.model.schedule.SeatNumbers
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SelectionRouterImpl(
    private val router: GlobalRouter
):  SelectionRouter{

    override fun goBack() {
        router.pop()
    }

    override fun openUserInfo(seanceInfo: SeanceInfo, selectedSeats: List<SeatNumbers>) {
        router.open(UserInfoRoute(
            seanceInfo = Json.encodeToString(seanceInfo),
            selectedSeats = Json.encodeToString(selectedSeats)
        ))
    }
}