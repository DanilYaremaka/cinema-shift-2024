package com.example.cinema_shift_2024

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinema_shift_2024.posters.presentation.PostersRoute
import com.example.cinema_shift_2024.posters.ui.PostersScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = PostersRoute) {
            composable<PostersRoute> {
                PostersScreen(
                    postersViewModel = koinViewModel(),
                    onItemSelected = { })
            }
        }
    }
}