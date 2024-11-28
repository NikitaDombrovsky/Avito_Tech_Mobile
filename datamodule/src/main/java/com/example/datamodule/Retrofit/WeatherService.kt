package com.example.datamodule.Retrofit

import com.example.data.storage.WeatherListEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

