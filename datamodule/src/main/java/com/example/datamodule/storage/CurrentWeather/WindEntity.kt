package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.Wind_Model

data class WindEntity(
    val speed: Double,
    val deg: Long,
) {
    companion object {}
}

fun WindEntity.toModel(): Wind_Model {
    return Wind_Model(
        speed = speed,
        deg = deg,
    )
}

fun WindEntity.Companion.fromModel(wind: Wind_Model): WindEntity {
    return WindEntity(
        wind.speed,
        wind.deg,
    )
}