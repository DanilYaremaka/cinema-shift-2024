package com.example.cinema_shift_2024.selection.presentation

import com.example.shared.data.model.schedule.SeanceInfo
import com.example.shared.data.model.schedule.SeatNumbers

interface SelectionRouter {

    fun goBack()

    fun openUserInfo(seanceInfo: SeanceInfo, selectedSeats: List<SeatNumbers>)
}