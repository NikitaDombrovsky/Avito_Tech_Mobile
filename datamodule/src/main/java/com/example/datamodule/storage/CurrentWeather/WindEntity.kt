package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.WindModel

data class WindEntity(
    val speed: Double,
    val deg: Long,
) {
    companion object {}
}

fun WindEntity.toModel(): WindModel {
    return WindModel(
        speed = speed,
        deg = deg,
    )
}

fun WindEntity.Companion.fromModel(wind: WindModel): WindEntity {
    return WindEntity(
        wind.speed,
        wind.deg,
    )
}