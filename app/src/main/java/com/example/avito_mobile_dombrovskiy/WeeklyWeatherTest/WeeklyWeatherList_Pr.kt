
package com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest

import com.example.avito_mobile_dombrovskiy.Main
import com.example.avito_mobile_dombrovskiy.Weather
import com.example.avito_mobile_dombrovskiy.WeatherResponse
import com.example.avito_mobile_dombrovskiy.fromModel
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.WeeklyWeather.WeeklyCity_Model
import com.example.domain.models.WeeklyWeather.WeeklyWeather_Model

data class WeeklyWeatherList_Pr(
  //  val main: WeeklyMain_Pr,
    //val list: List<WeeklyWeather_Pr>,
    val list: List<WeatherResponse>,
    val city: WeeklyCity_Pr
) {
    companion object {}
}

/*
fun WeeklyWeatherList_Pr.toModel(): WeeklyWeather_Model {
    // TODO*//*
    return WeeklyWeather_Model(
     //   main = main.toModel(),
        weather = list.map { it.toModel() },
        city = city.toModel()
    )
}
*/

/*fun WeatherResponse.Companion.fromModel(weatherlistModel: WeatherList_Model): WeatherResponse {
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

}*/
fun WeeklyWeatherList_Pr.Companion.fromModel(weatherList: WeeklyWeather_Model): WeeklyWeatherList_Pr {
    return WeeklyWeatherList_Pr(
       // main = WeeklyMain_Pr.fromModel(weatherList.main),
        list = weatherList.weather.map { weather -> WeatherResponse.fromModel(weather) },
        city = WeeklyCity_Pr.fromModel(weatherList.city)

    )
}
/*fun WeeklyWeatherList_Pr.Companion.fromModel(weatherList: WeeklyWeatherList_Model): WeeklyWeatherList_Pr {
    return WeeklyWeatherList_Pr(
        main = WeeklyMain_Pr.fromModel(weatherList.main),//WeeklyMain_Pr(weatherList.main.temp, weatherList.main.humidity),
        weather = weatherList.weather.map { weather -> WeeklyWeather_Pr.fromModel(weather) }

        //WeeklyWeather_Pr.fromModel(weatherList.weather)
        *//*         = weatherList.weather.map { weather ->
                    WeeklyWeather_Pr(
                        description = weather.description,
                        icon = weather.icon
                    )

                }*//*,
        city = WeeklyCity_Pr.fromModel(weatherList.city)
        *//*        WeeklyCity_Pr(
                    name = weatherList.city.name
                )*//*


    )
}*/
/*
data class WeeklyMain_Pr(
    val temp: Double,
    val humidity: Long
) {
    companion object {}
}
fun WeeklyMain_Pr.toModel(): WeeklyMain_Model {
    return WeeklyMain_Model(
        temp = temp,
        humidity = humidity
    )
}
fun WeeklyMain_Pr.Companion.fromModel(mainModel: WeeklyMain_Model): WeeklyMain_Pr {
    return WeeklyMain_Pr(
        temp = mainModel.temp,
        humidity = mainModel.humidity
    )
}*/


data class WeeklyCity_Pr(
    val name: String,
) {
    companion object {}
}
fun WeeklyCity_Pr.toModel(): WeeklyCity_Model {
    return WeeklyCity_Model(
        name = name
    )
}
fun WeeklyCity_Pr.Companion.fromModel(weeklyCity: WeeklyCity_Model): WeeklyCity_Pr {
    return WeeklyCity_Pr(
        name = weeklyCity.name
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

