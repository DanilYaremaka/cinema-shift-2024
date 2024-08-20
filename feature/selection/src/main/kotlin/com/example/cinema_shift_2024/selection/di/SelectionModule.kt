package com.example.cinema_shift_2024.selection.di

import com.example.cinema_shift_2024.selection.presentation.SelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val selectionModule = module {

    viewModel {(seanceInfo: String) ->
        SelectionViewModel(
            router = get(),
            seanceInfoJson = seanceInfo
        )
    }
}