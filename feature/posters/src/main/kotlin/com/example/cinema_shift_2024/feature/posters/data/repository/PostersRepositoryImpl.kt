package com.example.cinema_shift_2024.feature.posters.data.repository

import com.example.cinema_shift_2024.feature.posters.data.converter.PosterConverter
import com.example.cinema_shift_2024.feature.posters.data.network.PostersApi
import com.example.cinema_shift_2024.feature.posters.domain.entity.Film
import com.example.cinema_shift_2024.feature.posters.domain.repository.PostersRepository

class PostersRepositoryImpl(
    private val postersApi: PostersApi,
    private val converter: PosterConverter
): PostersRepository {

    override suspend fun getList(): List<Film> {
        val response = postersApi.getFilmsList()
        return response.films.map { converter.convert(it) }
    }
}