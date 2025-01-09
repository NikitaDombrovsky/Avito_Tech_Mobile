package com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest

import com.example.avito_mobile_dombrovskiy.WeatherResponse
import com.example.avito_mobile_dombrovskiy.fromModel
import com.example.domain.models.WeeklyWeather.WeeklyCityModel
import com.example.domain.models.WeeklyWeather.WeeklyWeatherModel

data class WeeklyWeatherList_Pr(
    val list: List<WeatherResponse>,
    val city: WeeklyCity_Pr
) {
    companion object {}
}

fun WeeklyWeatherList_Pr.Companion.fromModel(weatherList: WeeklyWeatherModel): WeeklyWeatherList_Pr {
    return WeeklyWeatherList_Pr(
        list = weatherList.weather.map { weather -> WeatherResponse.fromModel(weather) },
        city = WeeklyCity_Pr.fromModel(weatherList.city)

    )
}

data class WeeklyCity_Pr(
    val name: String,
) {
    companion object {}
}

fun WeeklyCity_Pr.toModel(): WeeklyCityModel {
    return WeeklyCityModel(
        name = name
    )
}

fun WeeklyCity_Pr.Companion.fromModel(weeklyCity: WeeklyCityModel): WeeklyCity_Pr {
    return WeeklyCity_Pr(
        name = weeklyCity.name
    )
}
