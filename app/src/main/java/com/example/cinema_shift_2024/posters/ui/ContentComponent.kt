package com.example.cinema_shift_2024.posters.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.cinema_shift_2024.posters.data.models.FilmModel
import com.example.cinema_shift_2024.posters.domain.entity.Film

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
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        FilmCard(film = film)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmCard(film: Film) {
    Card(border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)) {
        Column {
            Text(text = film.name)
            GlideImage(
                model = "https://shift-backend.onrender.com${film.img}",
                contentDescription = null
            )
            Text(text = film.userRatings.kinopoisk)
        }
    }
}