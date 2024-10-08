package com.example.cinema_shift_2024.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema_shift_2024.details.domain.usecase.GetDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class DetailsViewModel(
    private val filmId: String,
    private val getDetailsUseCase: GetDetailsUseCase,
    private val router: DetailsRouter
): ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Initial)
    val state: StateFlow<DetailsState> = _state

    fun loadDetails() {
        if (_state.value is DetailsState.Content || _state.value is DetailsState.Loading) {
            return
        }

        viewModelScope.launch {
            _state.value = DetailsState.Loading

            try {
                val details = getDetailsUseCase(filmId)
                _state.value = DetailsState.Content(details)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = DetailsState.Failure(ex.message)
            }
        }
    }

    fun goBack() {
        router.goBack()
    }

    fun openSchedule(filmId: String) {
        router.openSchedule(filmId)
    }
}