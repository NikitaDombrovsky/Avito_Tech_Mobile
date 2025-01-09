package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.WeatherListModel

data class WeatherListEntity(
    val weather: List<WeatherEntity>,
    val base: String? = "",
    val main: MainEntity,
    val visibility: Long,
    val wind: WindEntity,
    val dt: Long,
    val timezone: Long,
    val id: Long,
    val name: String? = "",
    val cod: Long,
    val dt_txt: String? = ""

) {
    companion object {}
}

fun WeatherListEntity.toModel(): WeatherListModel {
    return WeatherListModel(
        weather = WeatherEntity.Companion.fromListModel(weather),
        main = main.toModel(),
        name = if (name != null) name else "",
        dt_txt = if (dt_txt != null) dt_txt else ""
    )
}

