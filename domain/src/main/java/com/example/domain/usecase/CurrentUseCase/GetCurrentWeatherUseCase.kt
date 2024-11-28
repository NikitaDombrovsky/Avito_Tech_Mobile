package com.example.domain.usecase.CurrentUseCase

import com.example.domain.models.CurrentWeather.WeatherList
import com.example.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(): WeatherList =
        weatherRepository.getCurrentWeather()
}