package com.example.cinema_shift_2024.feature.posters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema_shift_2024.feature.posters.domain.usecase.GetListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class PostersViewModel(
    private val getListUseCase: GetListUseCase,
    private val router: PostersRouter
): ViewModel() {

    private val _state = MutableStateFlow<PostersState>(PostersState.Initial)
    val state: StateFlow<PostersState> = _state

    fun loadPosters() {
        if (_state.value is PostersState.Content || _state.value is PostersState.Loading)
            return

        viewModelScope.launch {
            _state.value = PostersState.Loading

            try {
                val posters = getListUseCase()
                _state.value = PostersState.Content(posters)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = PostersState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }

    fun reloadPosters() {
        _state.value = PostersState.Initial
        loadPosters()
    }

    fun openDetails(filmId: String) {
        router.openDetails(filmId)
    }
}