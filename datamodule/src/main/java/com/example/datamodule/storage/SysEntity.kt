package com.example.data.storage

import com.example.domain.models.CurrentWeather.Sys


data class SysEntity(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
) {
    companion object {}
}

fun SysEntity.toModel(): Sys {
    return Sys(
        type = type,
        id = id,
        country = country,
        sunrise = sunrise,
        sunset = sunset,
    )
}

fun SysEntity.Companion.fromModel(sys: Sys): SysEntity {
    return SysEntity(
        sys.type,
        sys.id,
        sys.country,
        sys.sunrise,
        sys.sunset,
    )
}