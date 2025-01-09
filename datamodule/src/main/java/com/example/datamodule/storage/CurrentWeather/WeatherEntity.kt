package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.WeatherModel

data class WeatherEntity(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,

    ) {
    companion object {}
}

// TODO ?
fun WeatherEntity.Companion.fromListModel(weatherEntityList: List<WeatherEntity>):
        List<WeatherModel> {
    return weatherEntityList.map { item ->
        item.toModel()
    }.toList()
}

fun WeatherEntity.toModel(): WeatherModel {
    return WeatherModel(
        id = id,
        main = main,
        description = description,
        icon = icon
    )
}

fun WeatherEntity.Companion.fromModel(weather: WeatherModel): WeatherEntity {
    return WeatherEntity(
        id = weather.id,
        main = weather.main,
        description = weather.description,
        icon = weather.icon
    )
}

