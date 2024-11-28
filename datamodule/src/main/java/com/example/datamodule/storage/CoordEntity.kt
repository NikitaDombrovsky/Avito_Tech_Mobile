package com.example.data.storage

import com.example.domain.models.CurrentWeather.Coord


data class CoordEntity(
    val lon: Double, val lat: Float
) {
    companion object {}
}

fun CoordEntity.toModel(): Coord {
    return Coord(
        lon = lon, lat = lat
    )
}

fun CoordEntity.Companion.fromModel(coord: Coord): CoordEntity {
    return CoordEntity(
        coord.lon,
        coord.lat
    )
}