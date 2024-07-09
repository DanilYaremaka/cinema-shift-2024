package com.example.cinema_shift_2024.navigation

import com.example.cinema_shift_2024.details.presentation.DetailsRouter

class DetailsRouterImpl(private val router: GlobalRouter): DetailsRouter {

    override fun goBack() {
        router.pop()
    }
}