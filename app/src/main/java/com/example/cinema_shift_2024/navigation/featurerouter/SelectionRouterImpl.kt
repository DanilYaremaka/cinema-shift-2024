package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.selection.presentation.SelectionRouter

class SelectionRouterImpl(
    private val router: GlobalRouter
):  SelectionRouter{

    override fun goBack() {
        router.pop()
    }
}