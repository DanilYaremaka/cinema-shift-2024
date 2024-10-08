package com.example.cinema_shift_2024.posters.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.cinema_shift_2024.feature.posters.domain.entity.Film
import com.example.cinema_shift_2024.posters.R

@Composable
fun ContentComponent(
    films: List<Film>,
    onItemSelected: (filmId: String) -> Unit
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(films) { film ->
            FilmItem(
                film,
                onItemSelected = { onItemSelected(film.id) })
        }
    }
}

@Composable
fun FilmItem(
    film: Film,
    onItemSelected: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        FilmCard(
            film = film,
            onItemSelected = onItemSelected
        )
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmCard(
    film: Film,
    onItemSelected: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(
                R.string.film_title_runtime_age,
                film.name,
                film.runtime,
                film.ageRating
            ),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 4.dp),
            fontSize = 32.sp,
        )
        GlideImage(
            model = film.img,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
        TextSample(text = stringResource(R.string.kinopoisk_rating, film.userRatings.kinopoisk))
        TextSample(text = stringResource(R.string.imdb_rating, film.userRatings.imdb))
        TextSample(text = textForList(film.genres))
        TextSample(text = "${film.country}")

        Button(
            onClick = onItemSelected,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.show_details),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TextSample(text: String) {
    Text(
        text = text,
        Modifier.padding(start = 4.dp, end = 4.dp)
    )
}

private fun textForList(list: List<String>): String =
    list.joinToString(separator = ", ")
