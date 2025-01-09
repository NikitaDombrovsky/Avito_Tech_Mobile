package com.example.datamodule.storage.CurrentWeather

import com.example.domain.models.CurrentWeather.CloudsModel


data class CloudsEntity(
    val all: Long,
) {
    companion object {}
}

fun CloudsEntity.toModel(): CloudsModel {
    return CloudsModel(
        all = all
    )
}

fun CloudsEntity.Companion.fromModel(cloudsModel: CloudsModel): CloudsEntity {
    return CloudsEntity(cloudsModel.all)
}