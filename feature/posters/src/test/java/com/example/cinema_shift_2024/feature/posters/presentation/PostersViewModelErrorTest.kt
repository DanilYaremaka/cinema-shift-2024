package com.example.cinema_shift_2024.feature.posters.presentation

import TestCoroutineExtension
import com.example.cinema_shift_2024.feature.posters.domain.usecase.GetListUseCase
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import thenThrowSafe

@ExtendWith(TestCoroutineExtension::class)
class PostersViewModelErrorTest {

    private val getListUseCase: GetListUseCase = mock()
    private val router: PostersRouter = mock()

    private val viewModel = PostersViewModel(getListUseCase, router)

    @Test
    fun `load posters EXPECT exception`() = runTest {
        val errorMessage = "errorMessage"
        whenever(getListUseCase()).thenThrowSafe(Exception(errorMessage))

        viewModel.loadPosters()

        assertEquals(PostersState.Failure(errorMessage), viewModel.state.value)

    }
}