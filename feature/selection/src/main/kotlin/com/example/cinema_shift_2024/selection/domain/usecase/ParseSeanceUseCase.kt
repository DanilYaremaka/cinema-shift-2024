package com.example.cinema_shift_2024.selection.domain.usecase

import com.example.cinema_shift_2024.selection.domain.repository.SelectionRepository

class ParseSeanceUseCase(private val repository: SelectionRepository) {

    operator fun invoke(seanceJson: String) = repository.parseSeanceJson(seanceJson)
}