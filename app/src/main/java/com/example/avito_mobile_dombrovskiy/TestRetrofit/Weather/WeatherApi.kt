package com.example.avito_mobile_dombrovskiy.TestRetrofit.Weather

import com.example.data.storage.WeatherDataClasses.WeatherList
import retrofit2.Response
import retrofit2.http.GET
interface WeatherApi {
    @GET("weather?q=Omsk&appid=4dfc05c3309bcd397630c1c51dda583b")
    suspend fun getWeather(): Response<com.example.data.storage.WeatherDataClasses.WeatherList>
}
