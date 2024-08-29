package com.example.cinema_shift_2024.selection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cinema_shift_2024.selection.domain.entity.Seat
import com.example.cinema_shift_2024.selection.domain.usecase.ParseSeanceUseCase
import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SelectionViewModel(
    private val router: SelectionRouter,
    private val seanceInfoJson: String,
    private val parseSeanceUseCase: ParseSeanceUseCase
): ViewModel() {

    private val _state =  MutableStateFlow<SelectionState>(SelectionState.Initial)
    val state: StateFlow<SelectionState> = _state

    fun getSeanceInfo() {
        _state.value = SelectionState.Loading
        try {
            val seanceInfo = parseSeanceUseCase(seanceInfoJson)
            _state.value = SelectionState.Content(seanceInfo)
        } catch (e: Exception) {
            _state.value = SelectionState.Failure(e.message)
        }
    }

    fun goBack() {
        router.goBack()
    }

    fun openUserInfo(seanceInfo: SeanceInfo, selectedSeats: List<Seat>, totalCost: Int) {
        Log.d("Selection", "$seanceInfo\n $selectedSeats\n $totalCost")
    }
}