package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.feature.posters.presentation.PostersRouter
import com.example.cinema_shift_2024.navigation.GlobalRouter

class PostersRouterImpl(
    private val router: GlobalRouter
): PostersRouter {

    override fun openDetails(filmId: String) {
        router.open(com.example.cinema_shift_2024.details.DetailsRoute(filmId))
    }
}