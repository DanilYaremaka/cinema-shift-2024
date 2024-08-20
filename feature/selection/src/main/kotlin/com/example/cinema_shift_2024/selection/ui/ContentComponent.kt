package com.example.cinema_shift_2024.selection.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shared.data.model.schedule.SeanceInfo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContentComponent(seanceInfo: SeanceInfo) {

    val seats = seanceInfo.hall.places

    Column {
        for (row in seats) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                for (seat in row) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(20.dp)
                    ) {

                    }
                }
            }
        }
    }
}