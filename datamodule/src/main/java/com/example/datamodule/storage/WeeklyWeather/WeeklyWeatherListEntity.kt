package com.example.datamodule.storage.WeeklyWeather


import com.example.datamodule.storage.CurrentWeather.WeatherListEntity
import com.example.datamodule.storage.CurrentWeather.toModel
import com.example.domain.models.WeeklyWeather.WeeklyCityModel
import com.example.domain.models.WeeklyWeather.WeeklyWeatherModel


data class WeeklyWeatherListEntity(
    val list: List<WeatherListEntity>,
    val city: WeeklyCityEntity
) {
    companion object {}
}

fun WeeklyWeatherListEntity.toModel(): WeeklyWeatherModel {
    return WeeklyWeatherModel(
        weather = list.map { it.toModel() },
        city = city.toModel()
    )
}

data class WeeklyCityEntity(
    val name: String,
) {
    companion object {}
}

fun WeeklyCityEntity.toModel(): WeeklyCityModel {
    return WeeklyCityModel(
        name = name
    )
}