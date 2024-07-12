@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.cinema_shift_2024.details.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.cinema_shift_2024.details.R
import com.example.cinema_shift_2024.details.domain.entity.Details
import com.example.shared.R as sharedR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentComponent(
    details: Details,
    onBackArrowPressed: () -> Unit,
    onOpenSchedulePressed: (filmId: String) -> Unit
) {
    TopAppBar(title = {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .clickable { onBackArrowPressed() }
                    .padding(end = 8.dp)
            )
            Text(
                text = details.name,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
            )
        }
    })

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FilmInfo(details = details)

        Button(
            onClick = { onOpenSchedulePressed(details.id) },
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.show_schedule),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FilmInfo(details: Details) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        GlideImage(
            model = details.img,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        TextSample(text = details.description)
        TextSample(
            text = stringResource(
                R.string.genres,
                textForList(list = details.genres)
            )
        )
        TextSample(text = stringResource(R.string.realise_date, details.releaseDate))
        TextSample(
            text = stringResource(
                R.string.actors,
                textForList(list = details.actors)
            )
        )
        TextSample(
            text = stringResource(
                R.string.directors,
                textForList(list = details.directors)
            )
        )
        TextSample(
            text = stringResource(
                R.string.country,
                details.country ?: stringResource(sharedR.string.unknown_country)
            )
        )
        HorizontalDivider(
            thickness = 80.dp,
            color = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
fun TextSample(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
    )
}

private fun textForList(list: List<String>): String =
    list.joinToString(separator = ", ")
