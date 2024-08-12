package com.example.shared.data.model.film
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Long,
    val code: String,
    val code2: String,
    val name: String
)
