package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.details.DetailsRoute
import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.posters.presentation.PostersRouter

class PostersRouterImpl(
    private val router: GlobalRouter
): PostersRouter {

    override fun openDetails(filmId: String) {
        router.open(DetailsRoute(filmId))
    }
}