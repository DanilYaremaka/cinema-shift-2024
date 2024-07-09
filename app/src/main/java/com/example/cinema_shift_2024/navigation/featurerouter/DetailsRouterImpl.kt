package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.details.presentation.DetailsRouter
import com.example.cinema_shift_2024.navigation.GlobalRouter

class DetailsRouterImpl(private val router: GlobalRouter): DetailsRouter {

    override fun goBack() {
        router.pop()
    }
}