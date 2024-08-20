package com.example.cinema_shift_2024.selection.presentation

import androidx.lifecycle.ViewModel
import com.example.shared.data.model.schedule.SeanceInfo

class SelectionViewModel(
    private val router: SelectionRouter,
    private val seanceInfo: SeanceInfo
): ViewModel() {



    fun getSeanceInfo(): String {
        return seanceInfo.toString()
    }
}