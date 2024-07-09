package com.example.cinema_shift_2024.navigation

import androidx.navigation.NavController

interface NavControllerHolder {

    fun setNavController(navController: NavController)

    fun clearNavController()
}