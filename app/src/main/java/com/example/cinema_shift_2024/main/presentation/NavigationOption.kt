package com.example.cinema_shift_2024.main.presentation

import com.example.cinema_shift_2024.posters.PostersRoute
import com.example.cinema_shift_2024.tickets.TicketsRoute
import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    POSTERS(PostersRoute::class),
    TICKETS(TicketsRoute::class)
}