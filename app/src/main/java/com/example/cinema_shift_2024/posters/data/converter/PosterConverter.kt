package com.example.cinema_shift_2024.posters.data.converter

import com.example.cinema_shift_2024.posters.data.models.AgeRating
import com.example.cinema_shift_2024.posters.data.models.FilmModel
import com.example.cinema_shift_2024.posters.domain.entity.Film
import com.example.cinema_shift_2024.posters.domain.entity.UserRatings

class PosterConverter {

    fun convert(model: FilmModel): Film =
        Film(
            id = model.id,
            name = model.name,
            runtime = model.runtime,
            ageRating = model.ageRating.name,
            userRatings = UserRatings(
                kinopoisk = model.userRatings.kinopoisk,
                imdb = model.userRatings.imdb
            ),
            img = "${IMAGE_BASE_URL}${model.img}",
            genres = model.genres,
            country = model.country?.name
        )

    companion object {
        private const val IMAGE_BASE_URL = "https://shift-backend.onrender.com"
    }
}