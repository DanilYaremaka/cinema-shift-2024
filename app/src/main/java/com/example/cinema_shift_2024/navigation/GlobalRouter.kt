package com.example.cinema_shift_2024.navigation

interface GlobalRouter {

    fun open(route: Any)

    fun openPoppingAllPrevious(route: Any)

    fun pop()
}