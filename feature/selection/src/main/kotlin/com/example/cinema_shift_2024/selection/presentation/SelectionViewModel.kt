package com.example.cinema_shift_2024.selection.presentation

import androidx.lifecycle.ViewModel
import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.serialization.json.Json

class SelectionViewModel(
    private val router: SelectionRouter,
    private val seanceInfoJson: String
): ViewModel() {

    private val seanceInfo = Json.decodeFromString<SeanceInfo>(seanceInfoJson)

    fun getSeanceInfo(): String {
        return seanceInfo.toString()
    }
}