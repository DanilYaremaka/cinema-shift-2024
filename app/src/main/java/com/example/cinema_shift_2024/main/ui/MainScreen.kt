package com.example.cinema_shift_2024.main.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cinema_shift_2024.details.DetailsRoute
import com.example.cinema_shift_2024.details.ui.DetailsScreen
import com.example.cinema_shift_2024.navigation.NavControllerHolder
import com.example.cinema_shift_2024.posters.PostersRoute
import com.example.cinema_shift_2024.posters.ui.PostersScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navControllerHolder = koinInject<NavControllerHolder>()
    /*val mainViewModel = koinViewModel<MainViewModel>()

    val state by mainViewModel.state.collectAsStateWithLifecycle()*/

    DisposableEffect(key1 = Unit) {
        /*navController.addOnDestinationChangedListener { _, destination, _ ->
            val openedOption = state.navigationOptions.firstOrNull { destination.hasRoute(it.route) }
            mainViewModel.handleOpenedScreen(openedOption)
        }*/

        navControllerHolder.setNavController(navController)
        onDispose {
            navControllerHolder.clearNavController()
        }
    }

    Surface {
        NavHost(navController = navController, startDestination = PostersRoute) {
            composable<PostersRoute> {
                PostersScreen(
                    postersViewModel = koinViewModel()
                )
            }
            composable<DetailsRoute> {
                val destination = it.toRoute<DetailsRoute>()
                DetailsScreen(
                    viewModel = koinViewModel { parametersOf(destination.filmId) }
                )
            }
        }
    }
}

inline fun <reified T: Any> NavGraphBuilder.animatedComposable(
    noinline block: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = ENTER_TRANSITION,
        exitTransition = EXIT_TRANSITION,
        popEnterTransition = POP_ENTER_TRANSITION,
        popExitTransition = POP_EXIT_TRANSITION,
        content = block
    )
}