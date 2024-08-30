package com.example.cinema_shift_2024.selection.presentation

import com.example.shared.data.model.schedule.SeanceInfo

interface SelectionState {

    data object Initial: SelectionState
    data object Loading: SelectionState
    data class Failure(val message: String?): SelectionState
    data class Content(val seanceInfo: SeanceInfo): SelectionState
}