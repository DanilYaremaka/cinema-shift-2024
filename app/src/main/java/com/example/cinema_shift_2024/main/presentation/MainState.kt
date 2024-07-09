package com.example.cinema_shift_2024.main.presentation

data class MainState(
    val navigationOptions: List<NavigationOption>,
    val selectedNavOption: NavigationOption?
)