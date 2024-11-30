package com.example.datamodule.storage

import com.example.domain.models.CurrentWeather.Coord_Model


data class CoordEntity(
    val lon: Double, val lat: Float
) {
    companion object {}
}

fun CoordEntity.toModel(): Coord_Model {
    return Coord_Model(
        lon = lon, lat = lat
    )
}

fun CoordEntity.Companion.fromModel(coordModel: Coord_Model): CoordEntity {
    return CoordEntity(
        coordModel.lon,
        coordModel.lat
    )
}