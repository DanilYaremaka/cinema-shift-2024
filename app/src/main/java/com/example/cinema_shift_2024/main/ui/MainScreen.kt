package com.example.cinema_shift_2024.main.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cinema_shift_2024.R
import com.example.cinema_shift_2024.details.DetailsRoute
import com.example.cinema_shift_2024.details.ui.DetailsScreen
import com.example.cinema_shift_2024.feature.posters.PostersRoute
import com.example.cinema_shift_2024.main.presentation.MainViewModel
import com.example.cinema_shift_2024.main.presentation.NavigationOption
import com.example.cinema_shift_2024.navigation.NavControllerHolder
import com.example.cinema_shift_2024.posters.ui.PostersScreen
import com.example.cinema_shift_2024.schedule.ScheduleRoute
import com.example.cinema_shift_2024.schedule.ui.ScheduleScreen
import com.example.cinema_shift_2024.tickets.TicketsRoute
import com.example.cinema_shift_2024.tickets.ui.TicketsScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navControllerHolder = koinInject<NavControllerHolder>()
    val mainViewModel = koinViewModel<MainViewModel>()

    val state by mainViewModel.state.collectAsStateWithLifecycle()

    DisposableEffect(key1 = Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val openedOption = state.navigationOptions.firstOrNull { destination.hasRoute(it.route) }
            mainViewModel.handleOpenedScreen(openedOption)
        }

        navControllerHolder.setNavController(navController)
        onDispose {
            navControllerHolder.clearNavController()
        }
    }

    Surface {
        Column {
            NavHost(
                navController = navController,
                startDestination = PostersRoute,
                modifier = Modifier.weight(1f),
            ) {
                animatedComposable<PostersRoute> {
                    PostersScreen(
                        postersViewModel = koinViewModel()
                    )
                }
                animatedComposable<DetailsRoute> {
                    val destination = it.toRoute<DetailsRoute>()
                    DetailsScreen(
                        viewModel = koinViewModel { parametersOf(destination.filmId) }
                    )
                }
                animatedComposable<TicketsRoute> {
                    TicketsScreen()
                }
                animatedComposable<ScheduleRoute> {
                    val destination = it.toRoute<ScheduleRoute>()
                    ScheduleScreen(
                        viewModel = koinViewModel { parametersOf(destination.filmId)}
                    )
                }
//                animatedComposable<SelectionRoute> {
//                    val destination = it.toRoute<SelectionRoute>()
//                    SelectionScreen(
//                        //destination.seanceInfo
//                    )
//                }
            }

            BottomNavigation(
                navigationOptions = state.navigationOptions,
                selectedNavigationOption = state.selectedNavOption,
                onItemClicked = mainViewModel::openOption
            )
        }

    }
}

@Composable
private fun BottomNavigation(
    navigationOptions: List<NavigationOption>,
    selectedNavigationOption: NavigationOption?,
    onItemClicked: (NavigationOption) -> Unit,
) {
    NavigationBar {
        for (option in navigationOptions) {
            NavigationBarItem(
                selected = selectedNavigationOption == option,
                onClick = { onItemClicked(option) },
                icon = { Icon(navOptionIcon(option), "") },
                label = { Text(text = navOptionLabel(option)) }
            )
        }
    }
}

private fun navOptionIcon(option: NavigationOption): ImageVector =
    when (option) {
        NavigationOption.POSTERS   -> Icons.Default.Home
        NavigationOption.TICKETS -> Icons.Default.DateRange
    }

@Composable
private fun navOptionLabel(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.POSTERS -> R.string.bot_nav_posters
        NavigationOption.TICKETS -> R.string.bot_nav_tickets
    }
)

inline fun <reified T: Any> NavGraphBuilder.animatedComposable(noinline block: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit) {
    composable<T>(
        enterTransition = ENTER_TRANSITION,
        exitTransition = EXIT_TRANSITION,
        popEnterTransition = POP_ENTER_TRANSITION,
        popExitTransition = POP_EXIT_TRANSITION,
        content = block
    )
}