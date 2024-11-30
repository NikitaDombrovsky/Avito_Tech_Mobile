package com.example.avito_mobile_dombrovskiy

import com.example.avito_mobile_dombrovskiy.CurrentWeather.Coord_Pr
import com.example.avito_mobile_dombrovskiy.CurrentWeather.fromModel
import com.example.domain.models.CurrentWeather.Main_Model
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.CurrentWeather.Weather_Model


data class WeatherResponse(
   // val coordModel: Coord_Pr,
    val main: Main,
    val weather: List<Weather>,
    val name: String
)
{ companion object}
fun WeatherResponse.Companion.fromModel(weatherlistModel: WeatherList_Model): WeatherResponse {
    var t = weatherlistModel.weather
    //TODO А как лучше?
    val listWeather : ArrayList<Weather> = ArrayList<Weather>()
    for (item in t){
        listWeather.add(Weather.fromModel(item))
    }
    return WeatherResponse(
       // coordModel = Coord_Pr.fromModel(weatherlistModel.coordModel),
        main = Main.fromModel(weatherlistModel.main),
        weather = listWeather,
        name = weatherlistModel.name
    )
}

data class Main(
    val temp: Double,
    val humidity: Long
) {
    companion object {}
}
fun Main.Companion.fromModel(main: Main_Model): Main {
    return Main(
        temp = main.temp,
        humidity = main.humidity
    )
}

data class Weather(
    val description: String,
    val icon: String
){
    companion object {}
}
fun Weather.Companion.fromModel(weather: Weather_Model): Weather {
    return Weather(
        description = weather.description,
        icon = weather.icon
    )
}
/*fun WeatherResponse.Companion.toWeather() = WeatherList_Model(
    coordModel = TODO(),
    weather = TODO(),
    base = TODO(),
    main = TODO(),
    visibility = TODO(),
    wind = TODO(),
    cloudsModel = TODO(),
    dt = TODO(),
    sysModel = TODO(),
    timezone = TODO(),
    id = TODO(),
    name = TODO(),
    cod = TODO()
    *//*    name = "$firstName $lastName",
    age = age,
    tel = tel*//*
)*/
