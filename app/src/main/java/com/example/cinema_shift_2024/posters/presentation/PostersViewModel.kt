package com.example.cinema_shift_2024.posters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema_shift_2024.posters.domain.usecase.GetListUseCase
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

    fun openDetails(filmId: String) {
        router.openDetails(filmId)
    }
}