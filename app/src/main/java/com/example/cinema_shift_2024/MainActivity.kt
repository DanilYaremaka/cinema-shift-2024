package com.example.cinema_shift_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cinema_shift_2024.main.ui.MainScreen
import com.example.cinema_shift_2024.ui.theme.Cinemashift2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cinemashift2024Theme {
                MainScreen()
            }
        }
    }
}
