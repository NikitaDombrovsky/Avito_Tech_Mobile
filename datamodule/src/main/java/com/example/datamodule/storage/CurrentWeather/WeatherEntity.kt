package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.Weather_Model

data class WeatherEntity(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
) {
    companion object {}
}


fun WeatherEntity.toModel(): Weather_Model {
    return Weather_Model(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}


fun WeatherEntity.Companion.fromModel(weather: Weather_Model): WeatherEntity {
    return WeatherEntity(
        id = weather.id,
        main = weather.main,
        description = weather.description,
        icon = weather.icon
    )
}

