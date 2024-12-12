package com.example.datamodule.RetrofitWeather

import com.example.datamodule.storage.CurrentWeather.WeatherListEntity
import com.example.datamodule.storage.WeeklyWeather.WeeklyWeatherListEntity
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

    @GET("forecast")
    suspend fun getWeeklyWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): List<WeeklyWeatherListEntity>
    @GET("forecast")
    suspend fun getWeeklyWeather_(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): WeeklyWeatherListEntity
}

