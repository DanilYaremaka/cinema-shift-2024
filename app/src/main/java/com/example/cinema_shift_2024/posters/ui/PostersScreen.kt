package com.example.cinema_shift_2024.posters.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.R
import com.example.cinema_shift_2024.posters.presentation.PostersState
import com.example.cinema_shift_2024.posters.presentation.PostersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostersScreen(
    postersViewModel: PostersViewModel,
    onItemSelected: (filmId: String) -> Unit
) {

    val postersState by postersViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        postersViewModel.loadPosters()
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(title = { Text(text = stringResource(id = R.string.posters_title)) })

        when (val state = postersState) {
            is PostersState.Initial,
            is PostersState.Loading -> LoadingComponent()

            is PostersState.Content -> ContentComponent(
                films =  state.films,
                onItemSelected = onItemSelected)

            is PostersState.Failure -> ErrorComponent(
                message = state.message.orEmpty(),
                onRetry = { postersViewModel.loadPosters() }
                )
        }
    }
}

