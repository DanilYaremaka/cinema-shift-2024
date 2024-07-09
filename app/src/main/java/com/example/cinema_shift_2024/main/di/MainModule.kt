package com.example.cinema_shift_2024.main.di

import com.example.cinema_shift_2024.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    viewModelOf(::MainViewModel)
}