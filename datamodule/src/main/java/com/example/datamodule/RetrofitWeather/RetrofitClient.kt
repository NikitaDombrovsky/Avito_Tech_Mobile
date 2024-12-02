package com.example.datamodule.RetrofitWeather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val weatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    // TODO Точно так?
    private const val WEEKLY_BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val weeklyWeatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(WEEKLY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}