package com.example.cinema_shift_2024.schedule.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema_shift_2024.schedule.R
import com.example.cinema_shift_2024.schedule.domain.entity.FilmSchedule
import com.example.shared.data.model.schedule.FilmSeance
import com.example.shared.data.model.schedule.HallName
import com.example.shared.data.model.schedule.ScheduleSeance
import com.example.shared.data.model.schedule.SeanceInfo
import com.example.shared.R as sharedR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentComponent(
    schedules: List<FilmSchedule>,
    onBackArrowPressed: () -> Unit,
    onContinuePress: (seanceInfo: SeanceInfo) -> Unit
) {
    var chosenDateIndex by remember { mutableIntStateOf(0) }
    var selectedSeance by remember { mutableStateOf<ScheduleSeance?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = {
                val filmDay = schedules[chosenDateIndex]
                onContinuePress(
                SeanceInfo(
                    filmId = "",
                    filmSeance = FilmSeance(
                        date = filmDay.date,
                        time = selectedSeance!!.time
                    ),
                    hall = selectedSeance!!.hall,
                    payedTickets = selectedSeance!!.payedTickets
                )
            )},
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            enabled = selectedSeance != null
        ) {
            Text(
                text = stringResource(sharedR.string.continue_button),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column {

            TopAppBar(title = {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { onBackArrowPressed() }
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = stringResource(R.string.schedule_title),
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                    )
                }
            })

            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState()),

                ) {
                for ((index, schedule) in schedules.withIndex()) {
                    SegmentedButton(
                        selected = index == chosenDateIndex,
                        onClick = {
                            chosenDateIndex = index
                            selectedSeance = null
                        },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = schedule.date)
                    }
                }
            }

            HallDates(
                hallName = HallName.Green,
                schedules[chosenDateIndex].seances,
                selectedSeance,
                onSeanceSelected = { selectedSeance = it }
            )
            HallDates(
                hallName = HallName.Blue,
                schedules[chosenDateIndex].seances,
                selectedSeance,
                onSeanceSelected = { selectedSeance = it }
            )
            HallDates(
                hallName = HallName.Red,
                schedules[chosenDateIndex].seances,
                selectedSeance,
                onSeanceSelected = { selectedSeance = it }
            )

        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HallDates(
    hallName: HallName,
    seances: List<ScheduleSeance>,
    selectedSeance: ScheduleSeance?,
    onSeanceSelected: (ScheduleSeance) -> Unit
) {

    HorizontalDivider(
        thickness = 16.dp,
        color = MaterialTheme.colorScheme.background
    )

    Column {
        Text(
            text = "Зал - ${hallName.name}",
            modifier = Modifier.padding(end = 8.dp, top = 8.dp, bottom = 8.dp, start = 16.dp)
        )

        FlowRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp)
        ) {
            for (seance in seances) {
                if (seance.hall.name == hallName)
                    OutlinedButton(
                        onClick = { onSeanceSelected(seance) },
                        colors = if (selectedSeance == seance) {
                            outlinedButtonColors(
                                containerColor = MaterialTheme.colorScheme.onTertiary

                            )
                        } else {
                            outlinedButtonColors(
                                containerColor = Color.Transparent
                            )
                        },
                    ) {
                        Text(
                            text = seance.time,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
            }
        }
    }
}