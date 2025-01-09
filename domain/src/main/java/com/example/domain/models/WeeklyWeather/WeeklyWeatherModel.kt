package com.example.domain.models.WeeklyWeather


import com.example.domain.models.CurrentWeather.WeatherListModel


data class WeeklyWeatherModel(
    val weather: List<WeatherListModel>,
    val city: WeeklyCityModel
) {
    companion object {}
}

data class WeeklyCityModel(
    val name: String,
) {
    companion object {}
}
