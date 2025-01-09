package com.example.avito_mobile_dombrovskiy


import com.example.domain.models.CurrentWeather.MainModel
import com.example.domain.models.CurrentWeather.WeatherListModel
import com.example.domain.models.CurrentWeather.WeatherModel


data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val name: String,
    val dt_txt: String
) {
    companion object
}

fun WeatherResponse.Companion.fromModel(weatherlistModel: WeatherListModel): WeatherResponse {
    return WeatherResponse(
        main = Main.fromModel(weatherlistModel.main),
        weather = weatherlistModel.weather.map { Weather.fromModel(it) },
        name = weatherlistModel.name,
        dt_txt = weatherlistModel.dt_txt
    )
}

data class Main(
    val temp: Double,
    val humidity: Long
) {
    companion object {}
}

fun Main.Companion.fromModel(main: MainModel): Main {
    return Main(
        temp = main.temp,
        humidity = main.humidity
    )
}

data class Weather(
    val description: String,
    val icon: String
) {
    companion object {}
}

fun Weather.Companion.fromModel(weather: WeatherModel): Weather {
    return Weather(
        description = weather.description,
        icon = weather.icon
    )
}
