package com.example.shared.data.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class FilmSeance(
    val date: String,
    val time: String
) {
    fun getDateTimeString(): String {
        return "Время: $time Дата: $date"
    }
}
