package com.example.cinema_shift_2024.selection.di

import com.example.cinema_shift_2024.selection.data.converter.SeanceJsonConverter
import com.example.cinema_shift_2024.selection.data.repository.SelectionRepositoryImpl
import com.example.cinema_shift_2024.selection.domain.repository.SelectionRepository
import com.example.cinema_shift_2024.selection.domain.usecase.ParseSeanceUseCase
import com.example.cinema_shift_2024.selection.presentation.SelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val selectionModule = module {

    singleOf(::SeanceJsonConverter)

    singleOf(::SelectionRepositoryImpl) bind SelectionRepository::class

    factoryOf(::ParseSeanceUseCase)

    viewModel {(seanceInfo: String) ->
        SelectionViewModel(
            router = get(),
            seanceInfoJson = seanceInfo,
            parseSeanceUseCase = get()
        )
    }
}