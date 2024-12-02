package com.example.avito_mobile_dombrovskiy.DI


import com.example.domain.usecase.CurrentUseCase.GetCurrentWeatherUseCase
import com.example.domain.usecase.WeeklyUseCase.GetWeeklyWeatherUseCase
import org.koin.dsl.module

val DomainModule = module {
    factory<GetCurrentWeatherUseCase> {
        GetCurrentWeatherUseCase(weatherRepository = get())

    }
    factory<GetWeeklyWeatherUseCase> {
        GetWeeklyWeatherUseCase(weatherRepository = get())

    }
}

