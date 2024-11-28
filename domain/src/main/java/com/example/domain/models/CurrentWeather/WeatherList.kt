package com.example.domain.models.CurrentWeather

class WeatherList(
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

    )


/*data class Root(
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
)*/

/*data class Coord(
    val lon: Double,
    val lat: Long,
)*/

/*data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)*/

/*data class Main(
    val temp: Double,
    @JsonProperty("feels_like")
    val feelsLike: Double,
    @JsonProperty("temp_min")
    val tempMin: Double,
    @JsonProperty("temp_max")
    val tempMax: Double,
    val pressure: Long,
    val humidity: Long,
    @JsonProperty("sea_level")
    val seaLevel: Long,
    @JsonProperty("grnd_level")
    val grndLevel: Long,
)*/
/*
data class Wind(
    val speed: Long,
    val deg: Long,
)*/

/*data class Clouds(
    val all: Long,
)*/

/*data class Sys(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)*/
