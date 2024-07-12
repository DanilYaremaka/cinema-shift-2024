package com.example.cinema_shift_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cinema_shift_2024.main.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            com.example.resources.theme.Cinemashift2024Theme {
                MainScreen()
            }
        }
    }
}
