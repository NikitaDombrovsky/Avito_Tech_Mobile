package com.example.avito_mobile_dombrovskiy.DI


import com.example.avito_mobile_dombrovskiy.WeatherViewModel_F

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel<WeatherViewModel_F>(){
        WeatherViewModel_F(
            getCurrentWeatherUseCase =  get(),
            getWeeklyWeatherUseCase = get()
            //getTasksUseCase = get()

        )
    }
}