package com.example.cinema_shift_2024.schedule.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema_shift_2024.schedule.domain.usecase.GetWeekScheduleUseCase
import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class ScheduleViewModel(
    private val router: ScheduleRouter,
    private val filmId: String,
    private val getWeekScheduleUseCase: GetWeekScheduleUseCase,
): ViewModel() {

    private val _state = MutableStateFlow<ScheduleState>(ScheduleState.Initial)
    val state: StateFlow<ScheduleState> = _state

    fun loadSchedule() {
        if (_state.value is ScheduleState.Content || _state.value is ScheduleState.Loading) {
            return
        }

        viewModelScope.launch {
            _state.value = ScheduleState.Loading

            try {
                val weekSchedule = getWeekScheduleUseCase(filmId)

                _state.value = ScheduleState.Content(weekSchedule)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = ScheduleState.Failure(ex.message)
            }
        }
    }

    fun goBack() {
        router.goBack()
    }

    fun openSelection(seanceInfo: SeanceInfo) {
        Log.d("ScheduleVM", seanceInfo.toString())
        //router.openSelection(seanceInfo)
    }
}