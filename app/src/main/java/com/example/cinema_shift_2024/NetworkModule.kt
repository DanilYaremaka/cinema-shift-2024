package com.example.cinema_shift_2024

import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

const val BASE_URL = "https://shift-backend.onrender.com/"

val networkModule = module {
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .build()
    }

    single {
        OkHttpClient().newBuilder()
            .addInterceptor(get<Interceptor>())
            .build()
    }

    single<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        Json.asConverterFactory("application/json; charset=UTF8".toMediaType())
    }
}

