package com.example.cinema_shift_2024.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val router: MainRouter,
): ViewModel() {

    private val _state = MutableStateFlow(MainState(
        NavigationOption.entries,
        NavigationOption.POSTERS,
    ))
    val state: StateFlow<MainState> = _state

    fun openOption(option: NavigationOption) {
        _state.value = _state.value.copy(selectedNavOption = option)
        when (option) {
            NavigationOption.POSTERS -> router.openPosters()
            NavigationOption.TICKETS -> router.openTickets()
        }
    }

    fun handleOpenedScreen(option: NavigationOption?) {
        _state.value = _state.value.copy(selectedNavOption = option)
    }
}