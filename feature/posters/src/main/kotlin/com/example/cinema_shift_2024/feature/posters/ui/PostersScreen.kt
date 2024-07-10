package com.example.cinema_shift_2024.posters.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinema_shift_2024.feature.posters.presentation.PostersState
import com.example.cinema_shift_2024.feature.posters.presentation.PostersViewModel
import com.example.cinema_shift_2024.resources.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostersScreen(
    postersViewModel: PostersViewModel
) {

    val postersState by postersViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        postersViewModel.loadPosters()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    val (x, y) = dragAmount
                    if (y > 0) {
                        postersViewModel.reloadPosters()
                    }
                }
            }
    ) {

        TopAppBar(
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.posters_title))
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.clickable { postersViewModel.reloadPosters() }
                    )
                }

            }
        )

        when (val state = postersState) {
            is PostersState.Initial,
            is PostersState.Loading -> LoadingComponent()

            is PostersState.Content -> ContentComponent(
                films =  state.films,
                onItemSelected = postersViewModel::openDetails)

            is PostersState.Failure -> ErrorComponent(
                message = state.message.orEmpty(),
                onRetry = { postersViewModel.loadPosters() }
                )
        }
    }
}

