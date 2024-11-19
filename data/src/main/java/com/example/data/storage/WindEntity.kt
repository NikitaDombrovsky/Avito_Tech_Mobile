package com.example.data.storage

import com.example.domain.models.CurrentWeather.Wind

data class WindEntity(
    val speed: Long,
    val deg: Long,
) {
    companion object {}
}

fun WindEntity.toModel(): Wind {
    return Wind(
        speed = speed,
        deg = deg,
    )
}

fun WindEntity.Companion.fromModel(wind: Wind): WindEntity {
    return WindEntity(
        wind.speed,
        wind.deg,
    )
}