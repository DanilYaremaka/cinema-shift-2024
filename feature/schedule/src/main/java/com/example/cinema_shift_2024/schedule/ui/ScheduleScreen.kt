package com.example.cinema_shift_2024.schedule.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.schedule.presentation.ScheduleState
import com.example.cinema_shift_2024.schedule.presentation.ScheduleViewModel
import com.example.shared.R
import com.example.shared.ui.ErrorComponent
import com.example.shared.ui.LoadingComponent

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel
) {

    val scheduleState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadSchedule()
    }

    when(val state = scheduleState) {
        is ScheduleState.Initial,
        is ScheduleState.Loading -> LoadingComponent()

        is ScheduleState.Failure -> ErrorComponent(
            message = state.message ?: stringResource(id = R.string.error_unknown_error),
            onRetry = {
                viewModel.loadSchedule()
            }
        )

        is ScheduleState.Content -> ContentComponent(
            schedules = state.schedule,
            onBackArrowPressed = viewModel::goBack,
            onContinuePress = viewModel::openSelection
        )
    }
}