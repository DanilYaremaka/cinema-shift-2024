package com.example.cinema_shift_2024.Posters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cinema_shift_2024.data.models.Film

@Composable
fun ContentComponent(
    films: List<Film>,
    onItemSelected: (filmId: String) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(films) { film ->
            FilmItem(film, onItemSelected)
        }
    }
}

@Composable
fun FilmItem(
    film: Film,
    onItemSelected: (filmId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(film.id) }
    ) {
        Text(text = film.name)
        Text(text = film.description)
        Text(text = film.actors.toString())
    }
}