package com.example.cinema_shift_2024.details.data.converter

import com.example.cinema_shift_2024.details.domain.entity.Details

class DetailsConverter(private val baseUrl: String) {

    fun convert(model: com.example.shared.data.model.FilmModel): Details =
        Details(
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
            country = model.country?.name,
            actors = getPersonList(model.actors),
            description = model.description,
            directors = getPersonList(model.directors),
            originalName = model.originalName,
            releaseDate = model.releaseDate
        )

    private fun getPersonList(persons: List<com.example.shared.data.model.FilmPerson>): List<String> =
        persons.map {it.fullName}
}