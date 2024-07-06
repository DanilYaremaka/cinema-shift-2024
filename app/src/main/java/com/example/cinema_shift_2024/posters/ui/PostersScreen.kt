package com.example.cinema_shift_2024.posters.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.R
import com.example.cinema_shift_2024.posters.presentation.PostersState
import com.example.cinema_shift_2024.posters.presentation.PostersViewModel

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
        Text(text = stringResource(id = R.string.posters_title))

        when (val state = postersState) {
            is PostersState.Initial,
            is PostersState.Loading -> LoadingComponent()

            is PostersState.Content -> ContentComponent(state.films) {
                onItemSelected
            }

            is PostersState.Failure -> ErrorComponent(state.message.orEmpty()) {
                postersViewModel.loadPosters()
            }
        }
    }
}

