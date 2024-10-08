package com.example.cinema_shift_2024.feature.posters.di

import com.example.cinema_shift_2024.feature.posters.data.converter.PosterConverter
import com.example.cinema_shift_2024.feature.posters.data.network.PostersApi
import com.example.cinema_shift_2024.feature.posters.data.repository.PostersRepositoryImpl
import com.example.cinema_shift_2024.feature.posters.domain.repository.PostersRepository
import com.example.cinema_shift_2024.feature.posters.domain.usecase.GetListUseCase
import com.example.cinema_shift_2024.feature.posters.presentation.PostersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val postersModule = module {
    single { get<Retrofit>().create(PostersApi::class.java) }

    single { PosterConverter(get<String>(named(name = "baseUrl"))) }
    singleOf(::PostersRepositoryImpl) bind PostersRepository::class

    factoryOf(::GetListUseCase)

    viewModelOf(::PostersViewModel)
}