package com.example.domain.repository

import com.example.domain.models.CurrentWeather.WeatherListModel
import com.example.domain.models.WeeklyWeather.WeeklyWeatherModel

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String, language: String): WeatherListModel
    suspend fun getWeeklyWeather(city: String, language: String): WeeklyWeatherModel
}

