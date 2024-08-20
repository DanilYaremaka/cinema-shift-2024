package com.example.cinema_shift_2024.selection.data.converter

import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.serialization.json.Json

class SeanceJsonConverter {

    fun convert(modelJson: String) = Json.decodeFromString<SeanceInfo>(modelJson)
}