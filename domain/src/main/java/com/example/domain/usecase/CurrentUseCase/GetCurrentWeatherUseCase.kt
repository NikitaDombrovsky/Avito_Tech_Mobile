package com.example.domain.usecase.CurrentUseCase

import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: String): WeatherList_Model =
        weatherRepository.getCurrentWeather(city = city)
}