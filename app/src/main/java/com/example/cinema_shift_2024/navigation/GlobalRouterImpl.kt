package com.example.cinema_shift_2024.navigation

import androidx.navigation.NavController

class GlobalRouterImpl: GlobalRouter, NavControllerHolder {

    private var navController: NavController? = null

    override fun open(route: Any) {
        navController?.navigate(route)
    }

    override fun openPoppingAllPrevious(route: Any) {
        TODO("Not yet implemented")
    }

    override fun pop() {
        navController?.popBackStack()
    }

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun clearNavController() {
        navController = null
    }
}