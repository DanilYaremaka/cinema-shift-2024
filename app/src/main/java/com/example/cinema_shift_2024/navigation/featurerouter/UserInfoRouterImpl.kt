package com.example.cinema_shift_2024.navigation.featurerouter

import com.example.cinema_shift_2024.navigation.GlobalRouter
import com.example.cinema_shift_2024.userInfo.presentation.UserInfoRouter

class UserInfoRouterImpl(
    private val router: GlobalRouter
): UserInfoRouter {

    override fun goBack() {
        router.pop()
    }
}