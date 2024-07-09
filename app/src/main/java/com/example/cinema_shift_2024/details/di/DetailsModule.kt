package com.example.cinema_shift_2024.details.di

import com.example.cinema_shift_2024.details.data.converter.DetailsConverter
import com.example.cinema_shift_2024.details.data.network.DetailsApi
import com.example.cinema_shift_2024.details.data.repository.DetailsRepositoryImpl
import com.example.cinema_shift_2024.details.domain.repository.DetailsRepository
import com.example.cinema_shift_2024.details.domain.usecase.GetDetailsUseCase
import com.example.cinema_shift_2024.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

var detailsModule = module {

    single { get<Retrofit>().create(DetailsApi::class.java) }

    single { DetailsConverter(get<String>(named(name = "baseUrl"))) }
    singleOf(::DetailsRepositoryImpl) bind DetailsRepository::class

    factoryOf(::GetDetailsUseCase)

    viewModel {(filmId: String) ->
        DetailsViewModel(filmId, get(), get())
    }
}