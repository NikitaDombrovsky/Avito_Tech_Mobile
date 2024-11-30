package com.example.datamodule.repository


import com.example.datamodule.storage.WeatherListEntity
import com.example.datamodule.storage.toModel
import com.example.datamodule.RetrofitWeather.RetrofitClient
import com.example.datamodule.RetrofitWeather.WeatherService
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.repository.WeatherRepository
import retrofit2.Retrofit

class WeatherRepositoryImpl() : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherList_Model {
        // RetrofitHelper.getInstance()
        // TODO Вынести RetrofitClient в принимаемые
        val test = (RetrofitClient.weatherService.getWeather(
            city = "Omsk",
            apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            language = "ru",
            units = "metric"

        )).toModel()
        return  test
/*        return (RetrofitClient.weatherService.getWeather(
            city = "Omsk",
            apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            language = "ru",
            units = "metric"

        )).toModel()*/
    }
}