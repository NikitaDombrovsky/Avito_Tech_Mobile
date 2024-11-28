package com.example.datamodule.storage

import com.example.data.storage.WeatherListEntity
import com.example.datamodule.Retrofit.RetrofitClient

interface _WeatherRealization {
    suspend fun getCurrentWeather() : WeatherListEntity{
        return RetrofitClient.weatherService.getWeather(city = "Omsk", apiKey = "Test")
    } //TODO LiveData вместо Flow
}