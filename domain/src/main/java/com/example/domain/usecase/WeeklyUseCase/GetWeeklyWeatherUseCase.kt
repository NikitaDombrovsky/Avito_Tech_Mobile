package com.example.domain.usecase.WeeklyUseCase

import com.example.domain.models.WeeklyWeather.WeeklyWeatherModel
import com.example.domain.repository.WeatherRepository

class GetWeeklyWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: String, language: String): WeeklyWeatherModel =
        weatherRepository.getWeeklyWeather(city = city, language = language)
}