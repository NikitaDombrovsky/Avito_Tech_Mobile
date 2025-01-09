package com.example.domain.usecase.CurrentUseCase

import com.example.domain.models.CurrentWeather.WeatherListModel
import com.example.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: String, language: String): WeatherListModel =
        weatherRepository.getCurrentWeather(city = city, language = language)
}