package com.example.cinema_shift_2024.schedule.di

import com.example.cinema_shift_2024.schedule.data.converter.ScheduleConverter
import com.example.cinema_shift_2024.schedule.data.network.ScheduleApi
import com.example.cinema_shift_2024.schedule.data.repository.ScheduleRepositoryImpl
import com.example.cinema_shift_2024.schedule.domain.repository.ScheduleRepository
import com.example.cinema_shift_2024.schedule.domain.usecase.GetWeekScheduleUseCase
import com.example.cinema_shift_2024.schedule.presentation.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val scheduleModule = module {

    single { get<Retrofit>().create(ScheduleApi::class.java) }

    singleOf(::ScheduleConverter)
    singleOf(::ScheduleRepositoryImpl) bind ScheduleRepository::class

    factoryOf(::GetWeekScheduleUseCase)

    viewModel {(filmId: String) ->
        ScheduleViewModel(
            filmId = filmId,
            router = get(),
            getWeekScheduleUseCase = get())
    }
}