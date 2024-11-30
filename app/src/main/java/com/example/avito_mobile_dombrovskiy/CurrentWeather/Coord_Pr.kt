package com.example.avito_mobile_dombrovskiy.CurrentWeather

import com.example.domain.models.CurrentWeather.Coord_Model


data class Coord_Pr(
    val lon: Double,
    val lat: Float
){
    companion object {}
}
fun Coord_Pr.Companion.fromModel(coordModel: Coord_Model): Coord_Pr {
    return Coord_Pr(
        lon = coordModel.lon,
        lat = coordModel.lat
        /*        temp = main.temp,
        humidity = main.humidity*/
    )
}
