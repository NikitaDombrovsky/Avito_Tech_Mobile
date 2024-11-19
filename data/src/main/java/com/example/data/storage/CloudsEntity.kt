package com.example.data.storage

import com.example.domain.models.CurrentWeather.Clouds

data class CloudsEntity(
    val all: Long,
) {
    companion object {}
}

fun CloudsEntity.toModel(): Clouds {
    return Clouds(
        all = all
    )
}

fun CloudsEntity.Companion.fromModel(clouds: Clouds): CloudsEntity {
    return CloudsEntity(clouds.all)
}