package com.example.cinema_shift_2024.selection.domain.repository

import com.example.shared.data.model.schedule.SeanceInfo

interface SelectionRepository {

    fun parseSeanceJson(seanceJson: String): SeanceInfo
}