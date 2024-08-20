package com.example.cinema_shift_2024.selection

import com.example.shared.data.model.schedule.SeanceInfo
import kotlinx.serialization.Serializable

@Serializable
data class SelectionRoute(val seanceInfo: SeanceInfo)