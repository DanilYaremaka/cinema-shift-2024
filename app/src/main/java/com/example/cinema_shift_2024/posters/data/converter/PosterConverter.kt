package com.example.cinema_shift_2024.posters.data.converter

import com.example.cinema_shift_2024.posters.domain.entity.Film

class PosterConverter(private val baseUrl: String) {

    fun convert(model: com.example.shared.data.model.FilmModel): Film =
        Film(
            id = model.id,
            name = model.name,
            runtime = model.runtime,
            ageRating = model.ageRating.name,
            userRatings = com.example.shared.data.model.UserRatings(
                kinopoisk = model.userRatings.kinopoisk,
                imdb = model.userRatings.imdb
            ),
            img = "${baseUrl}${model.img}",
            genres = model.genres,
            country = model.country?.name
        )
}