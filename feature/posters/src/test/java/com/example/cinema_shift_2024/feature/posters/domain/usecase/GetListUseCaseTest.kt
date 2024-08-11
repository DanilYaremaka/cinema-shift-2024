package com.example.cinema_shift_2024.feature.posters.domain.usecase

import com.example.cinema_shift_2024.feature.posters.domain.entity.Film
import com.example.cinema_shift_2024.feature.posters.domain.repository.PostersRepository
import com.example.shared.data.model.UserRatings
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class GetListUseCaseTest {
    private val repository: PostersRepository = mock()
    private val useCase = GetListUseCase(repository)

    @Test
    fun `invoke EXPECT list of films`() = runTest {
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
        val expected = listOf(film)
        whenever(repository.getList()).thenReturn(expected)

        val actual = useCase()

        assertEquals(expected, actual)
    }
}