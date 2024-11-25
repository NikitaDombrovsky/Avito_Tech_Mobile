package com.example.domain.models.CurrentWeather

/*data class Weather(
    val id : Long,
    val main: String,
    val description : String,
    val icon : String
)*/

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)
/*
data class WeatherEntity(
    val main: Main,
    val weather: List<Weather>,
    val name: String
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)*/
