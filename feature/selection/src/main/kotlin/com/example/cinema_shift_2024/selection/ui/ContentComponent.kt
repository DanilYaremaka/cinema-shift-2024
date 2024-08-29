package com.example.cinema_shift_2024.selection.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema_shift_2024.selection.domain.entity.Seat
import com.example.shared.data.model.schedule.SeanceInfo
import com.example.shared.R as sharedR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentComponent(
    seanceInfo: SeanceInfo,
    onBackArrowPressed: () -> Unit,
    onContinuePressed: (seanceInfo: SeanceInfo, selectedSeats: List<Seat>, totalCost: Int) -> Unit
) {

    var selectedSeats by remember { mutableStateOf(listOf<Seat>()) }

    var totalCost by remember { mutableIntStateOf(0) }

    Box(modifier = Modifier) {

        Button(
            onClick = {
                onContinuePressed(seanceInfo, selectedSeats, totalCost)
            },
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            enabled = selectedSeats.isNotEmpty()
        ) {
            Text(
                text = stringResource(sharedR.string.continue_button),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "К оплате: $totalCost рублей",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 15.dp, bottom = 90.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp),
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable { onBackArrowPressed() }
                                .padding(end = 8.dp)
                        )
                        Text(
                            text = seanceInfo.filmSeance.getDateTimeString(),
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            )
        }
    }
}

