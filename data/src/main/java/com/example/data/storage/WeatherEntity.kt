package com.example.data.storage

import com.example.domain.models.CurrentWeather.Clouds
import com.example.domain.models.CurrentWeather.Coord
import com.example.domain.models.CurrentWeather.Main
import com.example.domain.models.CurrentWeather.Sys
import com.example.domain.models.CurrentWeather.Weather
import com.example.domain.models.CurrentWeather.WeatherList
import com.example.domain.models.CurrentWeather.Wind


data class WeatherEntity(
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

    /*    val weather: WeatherList,
        val main: String,
        val description: String,
        val icon: String*/
) {
    companion object {}
}



fun WeatherEntity.toModel(): WeatherList {
    return WeatherList(
        id = id,
        weather = weather,
        main = main,
        base = base,
        coord = coord,
        visibility = visibility,
        wind = wind,
        clouds = clouds,
        dt = dt,
        sys = sys,
        timezone = timezone,
        name = name,
        cod = cod,
    )
}

fun WeatherEntity.Companion.fromModel(weather: WeatherList): WeatherEntity {
    return WeatherEntity(
        coord = weather.coord,
        weather = weather.weather,
        base = weather.base,
        main = weather.main,
        visibility = weather.visibility,
        wind = weather.wind,
        clouds = weather.clouds,
        dt = weather.dt,
        sys = weather.sys,
        timezone = weather.timezone,
        id = weather.id,
        name = weather.name,
        cod = weather.cod
    )
}

