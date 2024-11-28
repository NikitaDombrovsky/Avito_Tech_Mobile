package com.example.avito_mobile_dombrovskiy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService_old {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("lang") language: String = "ru",
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

object RetrofitClient_old {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val weatherServiceOld: WeatherService_old by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService_old::class.java)
    }
}