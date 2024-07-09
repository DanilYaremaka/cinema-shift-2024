package com.example.cinema_shift_2024.navigation

import com.example.cinema_shift_2024.details.presentation.DetailsRouter
import com.example.cinema_shift_2024.posters.presentation.PostersRouter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::GlobalRouterImpl) binds arrayOf(GlobalRouter::class, NavControllerHolder::class)

    singleOf(::PostersRouterImpl) bind PostersRouter::class

    singleOf(::DetailsRouterImpl) bind DetailsRouter::class
}