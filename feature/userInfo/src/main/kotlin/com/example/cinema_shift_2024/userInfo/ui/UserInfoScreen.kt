package com.example.cinema_shift_2024.userInfo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.shared.data.model.schedule.SeanceInfo
import com.example.shared.data.model.schedule.SeatNumbers
import kotlinx.serialization.json.Json

@Composable
fun UserInfoScreen(
    seanceInfoJson: String,
    selectedSeatsJson: String
) {
    val seanceInfo = Json.decodeFromString<SeanceInfo>(seanceInfoJson)
    val selectedSeats = Json.decodeFromString<List<SeatNumbers>>(selectedSeatsJson)

    Column {
        Text(text = seanceInfo.filmId)
        Text(text = seanceInfo.ticketSeance.toString())
        Text(text = seanceInfo.hall.name.toString())
        Text(text = selectedSeats.toString())
    }
}