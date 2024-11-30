package com.example.datamodule.RetrofitWeather

import com.example.datamodule.storage.WeatherListEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): WeatherListEntity
}

