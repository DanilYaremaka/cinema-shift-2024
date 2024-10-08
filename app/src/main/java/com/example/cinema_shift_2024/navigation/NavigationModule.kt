package com.example.cinema_shift_2024.navigation

import com.example.cinema_shift_2024.details.presentation.DetailsRouter
import com.example.cinema_shift_2024.feature.posters.presentation.PostersRouter
import com.example.cinema_shift_2024.main.presentation.MainRouter
import com.example.cinema_shift_2024.navigation.featurerouter.DetailsRouterImpl
import com.example.cinema_shift_2024.navigation.featurerouter.MainRouterImpl
import com.example.cinema_shift_2024.navigation.featurerouter.PostersRouterImpl
import com.example.cinema_shift_2024.navigation.featurerouter.ScheduleRouterImpl
import com.example.cinema_shift_2024.navigation.featurerouter.SelectionRouterImpl
import com.example.cinema_shift_2024.schedule.presentation.ScheduleRouter
import com.example.cinema_shift_2024.selection.presentation.SelectionRouter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::GlobalRouterImpl) binds arrayOf(GlobalRouter::class, NavControllerHolder::class)

    singleOf(::PostersRouterImpl) bind PostersRouter::class

    singleOf(::DetailsRouterImpl) bind DetailsRouter::class

    singleOf(::MainRouterImpl) bind MainRouter::class

    singleOf(::ScheduleRouterImpl) bind ScheduleRouter::class

    singleOf(::SelectionRouterImpl) bind SelectionRouter::class
}