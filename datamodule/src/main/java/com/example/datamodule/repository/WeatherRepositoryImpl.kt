package com.example.datamodule.repository


import com.example.datamodule.BuildConfig
import com.example.datamodule.storage.CurrentWeather.toModel
import com.example.datamodule.RetrofitWeather.RetrofitClient
import com.example.datamodule.storage.CurrentWeather.WeatherEntity
import com.example.datamodule.storage.CurrentWeather.fromListModel
import com.example.datamodule.storage.WeeklyWeather.toModel
import com.example.domain.models.CurrentWeather.WeatherListModel
import com.example.domain.models.WeeklyWeather.WeeklyWeatherModel
import com.example.domain.repository.WeatherRepository


class WeatherRepositoryImpl() : WeatherRepository {
    override suspend fun getCurrentWeather(city: String, language: String): WeatherListModel {
        val weatherListEntity = (RetrofitClient.weatherService.getWeather(
            city = city,
            // TODO After Build
            //apiKey = "",
            apiKey = BuildConfig.WAPI_KEY,
            language = language,
            units = "metric"

        ))
        return WeatherListModel(
            weather = WeatherEntity.Companion.fromListModel(weatherListEntity.weather),
            main = weatherListEntity.main.toModel(),
            name = if (weatherListEntity.name != null) weatherListEntity.name else "",
            dt_txt = if (weatherListEntity.dt_txt != null) weatherListEntity.dt_txt else ""
        )
    }


    override suspend fun getWeeklyWeather(city: String, language: String): WeeklyWeatherModel {
        return (RetrofitClient.weeklyWeatherService.getWeeklyWeather_(
            city = city,
            // TODO After Build
            //apiKey = "",
            apiKey = BuildConfig.WAPI_KEY,
            language = language,
            units = "metric"

        )).toModel()
    }
}