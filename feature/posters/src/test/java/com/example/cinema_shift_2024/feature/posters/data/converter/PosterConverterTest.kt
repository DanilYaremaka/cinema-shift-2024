package com.example.cinema_shift_2024.feature.posters.data.converter

import com.example.cinema_shift_2024.feature.posters.domain.entity.Film
import com.example.shared.data.model.AgeRating
import com.example.shared.data.model.FilmModel
import com.example.shared.data.model.FilmPerson
import com.example.shared.data.model.Professions
import com.example.shared.data.model.UserRatings
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PosterConverterTest {
    private val converter = PosterConverter(baseUrl = "https://shift-backend.onrender.com")

    @Test
    fun `convert film model EXPECT film`() {
        val model = FilmModel(
            id = "1",
            name = "Третий лишний",
            originalName = "Tretiy lishniy",
            description = "cool film ",
            releaseDate = " today",
            actors = listOf(
                FilmPerson(
                    id = "12",
                    fullName = "Boris",
                    professions = listOf(Professions.ACTOR)
                )
            ),
            directors = listOf(
                FilmPerson(
                    id = "13",
                    fullName = "Vova",
                    professions = listOf(Professions.DIRECTOR)
                )
            ),
            runtime = 123,
            ageRating = AgeRating.G,
            genres = listOf("horror", "comedy"),
            userRatings = UserRatings(
                kinopoisk = "1.2",
                imdb = "5.4"
            ),
            img = "/stroka",
            country = null
        )
        val expected = Film(
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

        val actual = converter.convert(model)

        assertEquals(expected, actual)
    }
}