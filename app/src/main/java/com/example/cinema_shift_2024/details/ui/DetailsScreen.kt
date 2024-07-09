package com.example.cinema_shift_2024.details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.R
import com.example.cinema_shift_2024.details.presentation.DetailsState
import com.example.cinema_shift_2024.details.presentation.DetailsViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel
) {

    val detailsState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadDetails()
    }

    Column {

        when (val state = detailsState) {
            is DetailsState.Initial,
            is DetailsState.Loading -> LoadingComponent()

            is DetailsState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = {
                    viewModel.loadDetails()
                }
            )

            is DetailsState.Content -> ContentComponent(
                details = state.details,
                onBackArrowPressed = viewModel::goBack
            )
        }
    }
}