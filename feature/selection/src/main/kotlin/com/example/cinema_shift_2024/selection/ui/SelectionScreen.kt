package com.example.cinema_shift_2024.selection.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.selection.presentation.SelectionState
import com.example.cinema_shift_2024.selection.presentation.SelectionViewModel
import com.example.shared.R
import com.example.shared.ui.ErrorComponent
import com.example.shared.ui.LoadingComponent

@Composable
fun SelectionScreen(
    viewModel: SelectionViewModel
) {

    val selectionState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getSeanceInfo()
    }

    when (val state = selectionState) {
        is SelectionState.Initial,
        is SelectionState.Loading -> LoadingComponent()

        is SelectionState.Failure -> ErrorComponent(
            message = state.message ?: stringResource(id = R.string.error_unknown_error),
            onRetry = {
                viewModel.getSeanceInfo()
            }
        )

        is SelectionState.Content -> ContentComponent(
            seanceInfo = state.seanceInfo,
            onBackArrowPressed = viewModel::goBack,
            onContinuePressed = viewModel::openUserInfo
        )
    }
}