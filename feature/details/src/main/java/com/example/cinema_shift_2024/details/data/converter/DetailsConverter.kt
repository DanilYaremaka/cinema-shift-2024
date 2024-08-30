package com.example.cinema_shift_2024.details.data.converter

import com.example.cinema_shift_2024.details.domain.entity.Details
import com.example.shared.data.model.film.FilmModel
import com.example.shared.data.model.film.FilmPerson
import com.example.shared.data.model.film.UserRatings

class DetailsConverter(private val baseUrl: String) {

    fun convert(model: FilmModel): Details =
        Details(
            id = model.id,
            name = model.name,
            runtime = model.runtime,
            ageRating = model.ageRating.name,
            userRatings = UserRatings(
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

    private fun getPersonList(persons: List<FilmPerson>): List<String> =
        persons.map {it.fullName}
}