package com.example.cinema_shift_2024.selection.data.repository

import com.example.cinema_shift_2024.selection.data.converter.SeanceJsonConverter
import com.example.cinema_shift_2024.selection.domain.repository.SelectionRepository
import com.example.shared.data.model.schedule.SeanceInfo

class SelectionRepositoryImpl(
    private val converter: SeanceJsonConverter
): SelectionRepository {

    override fun parseSeanceJson(seanceJson: String): SeanceInfo {

        return converter.convert(seanceJson)
    }
}