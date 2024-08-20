package com.example.cinema_shift_2024.selection.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.cinema_shift_2024.selection.presentation.SelectionViewModel

@Composable
fun SelectionScreen(
    viewModel: SelectionViewModel
) {

    Column {
        Text(text = viewModel.getSeanceInfo())
    }
}