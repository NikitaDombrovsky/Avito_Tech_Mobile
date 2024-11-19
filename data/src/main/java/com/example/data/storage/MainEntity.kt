package com.example.data.storage

import com.example.domain.models.CurrentWeather.Main


data class MainEntity(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Long,
    val humidity: Long,
    val sea_level: Long,
    val grnd_level: Long,

    ) {
    companion object {}
}

fun MainEntity.toModel(): Main {
    return Main(
        temp = temp,
        feels_like = feels_like,
        temp_min = temp_min,
        temp_max = temp_max,
        pressure = pressure,
        humidity = humidity,
        sea_level = sea_level,
        grnd_level = grnd_level,
    )
}

fun MainEntity.Companion.fromModel(main: Main): MainEntity {
    return MainEntity(
        main.temp,
        main.feels_like,
        main.temp_min,
        main.temp_max,
        main.pressure,
        main.humidity,
        main.sea_level,
        main.grnd_level
    )
}