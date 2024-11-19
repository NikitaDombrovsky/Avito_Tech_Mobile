package com.example.data.storage

import com.example.domain.models.CurrentWeather.Clouds
import com.example.domain.models.CurrentWeather.Coord
import com.example.domain.models.CurrentWeather.Main
import com.example.domain.models.CurrentWeather.Sys
import com.example.domain.models.CurrentWeather.Weather
import com.example.domain.models.CurrentWeather.WeatherList
import com.example.domain.models.CurrentWeather.Wind


data class WeatherListEntity(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,

    ) {
    companion object {}
}
fun WeatherListEntity.toModel(): WeatherList{
    return WeatherList(
        coord = coord,
        weather = weather,
        base = base,
        main = main,
        visibility = visibility,
        wind = wind,
        clouds = clouds,
        dt = dt,
        sys =  sys,
        timezone = timezone,
        id = id,
        name = name,
        cod =  cod,
    )
}
fun WeatherListEntity.Companion.fromModel(weatherList: WeatherList): WeatherListEntity {
    return WeatherListEntity(
        weatherList.coord,
        weatherList.weather,
        weatherList.base,
        weatherList.main,
        weatherList.visibility,
        weatherList.wind,
        weatherList.clouds,
        weatherList.dt,
        weatherList.sys,
        weatherList.timezone,
        weatherList.id,
        weatherList.name,
        weatherList.cod
    )
}

