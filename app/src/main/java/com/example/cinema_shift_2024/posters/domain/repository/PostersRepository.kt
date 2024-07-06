package com.example.cinema_shift_2024.posters.domain.repository

import com.example.cinema_shift_2024.posters.domain.entity.Film

interface PostersRepository {

    suspend fun getList(): List<Film>
}