package com.example.domain.usecase.WeeklyUseCase

import com.example.domain.models.WeeklyWeather.WeeklyWeatherList_Model
import com.example.domain.repository.WeatherRepository

class GetWeeklyWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: String): List<WeeklyWeatherList_Model> =
        weatherRepository.getWeeklyWeather(city = city)
}