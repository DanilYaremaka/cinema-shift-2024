package com.example.cinema_shift_2024

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cinema_shift_2024.details.DetailsRoute
import com.example.cinema_shift_2024.details.ui.DetailsScreen
import com.example.cinema_shift_2024.posters.PostersRoute
import com.example.cinema_shift_2024.posters.ui.PostersScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = PostersRoute) {
            composable<PostersRoute> {
                PostersScreen(
                    postersViewModel = koinViewModel(),
                    onItemSelected = { navController.navigate(DetailsRoute(filmId = it)) })
            }
            composable<DetailsRoute> {
                val destination = it.toRoute<DetailsRoute>()
                DetailsScreen(
                    viewModel = koinViewModel { parametersOf(destination.filmId) },
                    onBackArrowPressed = { navController.popBackStack() }
                )
            }
        }
    }
}