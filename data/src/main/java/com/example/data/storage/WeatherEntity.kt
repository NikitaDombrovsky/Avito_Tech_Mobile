package com.example.data.storage

import com.example.domain.models.CurrentWeather.Weather

data class WeatherEntity(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
) {
    companion object {}
}

fun WeatherEntity.toModel(): Weather {
    return Weather(
        id = id,
        main = main,
        description = description,
        icon = icon,
    )
}

fun WeatherEntity.Companion.fromModel(weather: Weather): WeatherEntity {
    return WeatherEntity(
        weather.id,
        weather.main,
        weather.description,
        weather.icon
    )
}