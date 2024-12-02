package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.Clouds_Model


data class CloudsEntity(
    val all: Long,
) {
    companion object {}
}

fun CloudsEntity.toModel(): Clouds_Model {
    return Clouds_Model(
        all = all
    )
}

fun CloudsEntity.Companion.fromModel(cloudsModel: Clouds_Model): CloudsEntity {
    return CloudsEntity(cloudsModel.all)
}