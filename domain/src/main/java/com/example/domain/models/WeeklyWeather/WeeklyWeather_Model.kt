
package com.example.domain.models.WeeklyWeather


import com.example.domain.models.CurrentWeather.WeatherList_Model


data class WeeklyWeather_Model(
    //val main: WeeklyMain_Model,
    val weather: List<WeatherList_Model>,
    val city: WeeklyCity_Model
) {
    companion object {}
}
/*fun WeeklyWeatherList_Model.toModel(): WeeklyWe*/
/*data class WeeklyMain_Model(
    val temp: Double,
    val humidity: Long
) {
    companion object {}
}*/
/*data class WeeklyWeather_Model (
    val description: String,
    val icon: String
){
    companion object {}
}*/
data class WeeklyCity_Model(
    val name: String,
) {
    companion object {}
}
/*
fun WeeklyWeatherListEntity.toModel(): WeatherList_Model{
    val listWeather : ArrayList<Weather_Model> = ArrayList<Weather_Model>()
    for (item in weather){
        listWeather.add(item.toModel())
    }
    return WeatherList_Model(
        weather = listWeather,
        base = base,
        main = main.toModel(),
        visibility = visibility,
        wind = wind.toModel(),
        dt = dt,
        timezone = timezone,
        id = id,
        name = name,
        cod =  cod,
    )
}
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
*/

