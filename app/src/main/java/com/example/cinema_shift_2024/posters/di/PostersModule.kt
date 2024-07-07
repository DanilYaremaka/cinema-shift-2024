package com.example.cinema_shift_2024.posters.di

import com.example.cinema_shift_2024.posters.data.converter.PosterConverter
import com.example.cinema_shift_2024.posters.data.network.PostersApi
import com.example.cinema_shift_2024.posters.data.repository.PostersRepositoryImpl
import com.example.cinema_shift_2024.posters.domain.repository.PostersRepository
import com.example.cinema_shift_2024.posters.domain.usecase.GetListUseCase
import com.example.cinema_shift_2024.posters.presentation.PostersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "https://shift-backend.onrender.com"

val postersModule = module {
    single { get<Retrofit>().create(PostersApi::class.java) }

    single { PosterConverter(BASE_URL) }
    singleOf(::PostersRepositoryImpl) bind PostersRepository::class

    factoryOf(::GetListUseCase)

    viewModelOf(::PostersViewModel)
}