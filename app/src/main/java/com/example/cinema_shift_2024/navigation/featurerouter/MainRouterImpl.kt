package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.main.presentation.MainRouter
import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.posters.PostersRoute
import com.example.cinema_shift_2024.tickets.TicketsRoute

class MainRouterImpl(
    private val globalRouter: GlobalRouter
): MainRouter {

    override fun openPosters() {
        globalRouter.openPoppingAllPrevious(PostersRoute)
    }

    override fun openTickets() {
        globalRouter.openPoppingAllPrevious(TicketsRoute)
    }
}