package com.example.cinema_shift_2024

import android.app.Application
import com.example.cinema_shift_2024.details.di.detailsModule
import com.example.cinema_shift_2024.feature.posters.di.postersModule
import com.example.cinema_shift_2024.main.di.mainModule
import com.example.cinema_shift_2024.navigation.navigationModule
import com.example.cinema_shift_2024.schedule.di.scheduleModule
import com.example.cinema_shift_2024.selection.di.selectionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CinemaApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CinemaApplication)
            modules(
                networkModule,
                postersModule,
                detailsModule,
                navigationModule,
                mainModule,
                scheduleModule,
                selectionModule
            )
        }
    }
}