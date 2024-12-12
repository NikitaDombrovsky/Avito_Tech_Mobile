
package com.example.datamodule.storage.WeeklyWeather


import com.example.datamodule.storage.CurrentWeather.WeatherListEntity
import com.example.datamodule.storage.CurrentWeather.toModel
import com.example.domain.models.WeeklyWeather.WeeklyCity_Model
import com.example.domain.models.WeeklyWeather.WeeklyWeather_Model


data class WeeklyWeatherListEntity(
   // val main: WeeklyMainEntity,
    //val list: List<WeeklyWeatherEntity>,
    val list: List<WeatherListEntity>,
    val city: WeeklyCityEntity
) {
    companion object {}
}
fun WeeklyWeatherListEntity.toModel(): WeeklyWeather_Model{
    // TODO Вот так циклы сделать
  //  val listWeather: List<WeeklyWeather_Model> = weather.map { it.toModel() }
/*    // TODO Изменить эту часть
    val listWeather : ArrayList<WeeklyWeather_Model> = ArrayList<WeeklyWeather_Model>()
    for (item in weather){
        listWeather.add(item.toModel())
    }
    // TODO*/
    return WeeklyWeather_Model(
       // main = main.toModel(),
        weather = list.map { it.toModel() },
        city = city.toModel()
    )
}
/*data class WeeklyMainEntity(
    val temp: Double,
    val humidity: Long
) {
    companion object {}
}
fun WeeklyMainEntity.toModel(): WeeklyMain_Model{
    return WeeklyMain_Model(
        temp = temp,
        humidity = humidity
    )
}*/
/*data class WeeklyWeatherEntity (
    val description: String,
    val icon: String
){
    companion object {}
}
fun WeeklyWeatherEntity.toModel(): WeeklyWeather_Model{
    return WeeklyWeather_Model(
        description = description,
        icon = icon
    )
}*/
data class WeeklyCityEntity(
    val name: String,
) {
    companion object {}
}
fun WeeklyCityEntity.toModel(): WeeklyCity_Model{
    return WeeklyCity_Model(
        name = name
    )
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

