package com.example.cinema_shift_2024.selection.di

import com.example.cinema_shift_2024.selection.presentation.SelectionViewModel
import com.example.shared.data.model.schedule.SeanceInfo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val selectionModule = module {

    viewModel {(seanceInfo: SeanceInfo) ->
        SelectionViewModel(
            router = get(),
            seanceInfo = seanceInfo
        )
    }
}