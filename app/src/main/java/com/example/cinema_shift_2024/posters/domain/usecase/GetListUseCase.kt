package com.example.cinema_shift_2024.posters.domain.usecase

import com.example.cinema_shift_2024.posters.domain.entity.Film
import com.example.cinema_shift_2024.posters.domain.repository.PostersRepository

class GetListUseCase(private val repository: PostersRepository) {

    suspend operator fun invoke(): List<Film> = repository.getList()
}