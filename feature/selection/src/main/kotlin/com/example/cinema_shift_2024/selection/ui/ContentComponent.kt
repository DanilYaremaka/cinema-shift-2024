package com.example.cinema_shift_2024.selection.ui

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinema_shift_2024.selection.R
import com.example.cinema_shift_2024.selection.domain.entity.Seat
import com.example.shared.data.model.schedule.HallName
import com.example.shared.data.model.schedule.Place
import com.example.shared.data.model.schedule.PlaceType
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

            PriceList(hallName = seanceInfo.hall.name)

            Text(
                text = "зал - ${seanceInfo.hall.name}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp)
            )

            ScreenView()

            SeatsGrid(
                seats = seanceInfo.hall.places,
                selectedSeats = selectedSeats,
                onSeatSelected = { seat ->
                    if (selectedSeats.contains(seat)) {
                        selectedSeats = selectedSeats - seat
                        totalCost -= seat.price
                    } else {
                        if (selectedSeats.size < 5) {
                            selectedSeats = selectedSeats + seat
                            totalCost += seat.price
                        }
                    }
                }
            )
        }
    }

}


@Composable
fun SeatsGrid(
    seats: List<List<Place>>,
    selectedSeats: List<Seat>,
    onSeatSelected: (Seat) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            for ((rowIndex, row) in seats.withIndex()) {
                Row(
                    modifier = Modifier
                        .padding(4.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                    ) {
                        Text(
                            text = "${rowIndex + 1}",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                    }
                    for ((columnIndex, seat) in row.withIndex()) {

                        val seatNumbers = Seat(
                            column = columnIndex + 1,
                            row = rowIndex + 1,
                            price = seat.price,
                            placeType = seat.type
                        )

                        SeatItem(
                            selectedSeats = selectedSeats,
                            onSeatSelected = onSeatSelected,
                            seat = seatNumbers
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SeatItem(
    selectedSeats: List<Seat>,
    onSeatSelected: (Seat) -> Unit,
    seat: Seat
) {
    Box(modifier = Modifier.size(20.dp)) {
        val buttonSize = if (selectedSeats.contains(seat) || seat.placeType == PlaceType.BLOCKED)
            20.dp
        else
            15.dp

        Button(
            onClick = {
                onSeatSelected(seat)
            },
            modifier = Modifier
                .size(buttonSize)
                .align(Alignment.Center),
            colors = when (seat.placeType) {
                PlaceType.BLOCKED -> ButtonDefaults.buttonColors()
                PlaceType.ECONOM -> ButtonDefaults.buttonColors()
                PlaceType.COMFORT -> ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                )
            },
            enabled = seat.placeType!=PlaceType.BLOCKED
        ) {

        }
        if (selectedSeats.contains(seat)) {
            Text(
                text = seat.column.toString(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PriceList(hallName: HallName) {

    val economCost: String
    val comfortCost: String

    when (hallName) {
        HallName.Red -> {
            economCost = stringResource(R.string.econom_red_price)
            comfortCost = stringResource(R.string.comfort_red_price)
        }

        HallName.Blue -> {
            economCost = stringResource(R.string.econom_blue_price)
            comfortCost = stringResource(R.string.comfort_blue_price)
        }

        HallName.Green -> {
            economCost = stringResource(R.string.econom_green_price)
            comfortCost = stringResource(R.string.comfort_green_price)
        }
    }

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 10.dp, start = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        maxItemsInEachRow = 2
    ) {

        SeatPrice(
            color = ButtonDefaults.buttonColors().disabledContainerColor,
            text = stringResource(R.string.blocked_string)
        )
        SeatPrice(
            color = Color.Magenta,
            text = stringResource(R.string.comfort_string, comfortCost)
        )
        SeatPrice(
            color = ButtonDefaults.buttonColors().containerColor,
            text = stringResource(R.string.econom_string, economCost)
        )
    }
}

@Composable
fun SeatPrice(color: Color, text: String) {
    Row(
        modifier = Modifier.padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(
                    color = color
                )
                .padding(end = 4.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}


@Composable
fun ScreenView() {
    Text(
        text = stringResource(R.string.screen),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    HorizontalDivider(
        thickness = 2.dp,
        color = Color.Black,
        modifier = Modifier
            .padding(top = 5.dp, bottom = 25.dp, start = 5.dp, end = 5.dp)
    )
}
