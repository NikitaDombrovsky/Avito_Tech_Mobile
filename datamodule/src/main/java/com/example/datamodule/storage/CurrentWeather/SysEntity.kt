package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.Sys_Model


data class SysEntity(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
) {
    companion object {}
}

fun SysEntity.toModel(): Sys_Model {
    return Sys_Model(
        type = type,
        id = id,
        country = country,
        sunrise = sunrise,
        sunset = sunset,
    )
}

fun SysEntity.Companion.fromModel(sysModel: Sys_Model): SysEntity {
    return SysEntity(
        sysModel.type,
        sysModel.id,
        sysModel.country,
        sysModel.sunrise,
        sysModel.sunset,
    )
}