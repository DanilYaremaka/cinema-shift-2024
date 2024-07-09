package com.example.cinema_shift_2024.tickets.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketsScreen() {
    
    TopAppBar(
        title = { Text(text = stringResource(R.string.tickets_title)) },
    )

    Text(text = "В разработке")
}