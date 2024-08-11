package com.example.cinema_shift_2024.feature.posters.presentation

import TestCoroutineExtension
import app.cash.turbine.test
import com.example.cinema_shift_2024.feature.posters.domain.entity.Film
import com.example.cinema_shift_2024.feature.posters.domain.usecase.GetListUseCase
import com.example.shared.data.model.UserRatings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import thenNeverAnswer

@ExperimentalCoroutinesApi
@ExtendWith(TestCoroutineExtension::class)
class PostersViewModelTest {

    private val getListUseCase: GetListUseCase = mock()
    private val router: PostersRouter = mock()

    private val viewModel = PostersViewModel(getListUseCase, router)

    @Test
    fun `init view model EXPECT initial state`() {
        assertEquals(PostersState.Initial, viewModel.state.value)
    }

    @Test
    fun `load films EXPECT loading state`() = runTest {
        whenever(getListUseCase()).thenNeverAnswer()

        viewModel.state.drop(1).test {
            viewModel.loadPosters()

            assertEquals(PostersState.Loading, awaitItem())
        }
    }

    @Test
    fun `load film EXPECT content state`() = runTest {
        val film = Film(
            id = "1",
            name = "Третий лишний",
            runtime = 123,
            ageRating = "G",
            genres = listOf("horror", "comedy"),
            userRatings = UserRatings(
                kinopoisk = "1.2",
                imdb = "5.4"
            ),
            img = "https://shift-backend.onrender.com/stroka",
            country = null
        )

        whenever(getListUseCase()).thenReturn(listOf(film))

        viewModel.state.drop(1).test {
            viewModel.loadPosters()

            assertEquals(PostersState.Content(listOf(film)), awaitItem())
        }
    }
}