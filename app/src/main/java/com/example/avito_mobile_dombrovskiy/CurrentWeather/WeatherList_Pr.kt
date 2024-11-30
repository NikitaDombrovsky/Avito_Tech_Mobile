package com.example.avito_mobile_dombrovskiy.CurrentWeather


import com.example.avito_mobile_dombrovskiy.fromModel
import com.example.domain.models.CurrentWeather.WeatherList_Model


class WeatherList_Pr(
    val coordModel: Coord_Pr,
    val weather: List<Weather_Pr>,
    val base: String,
    val main: Main_Pr,
    val visibility: Long,
    val wind: Wind_Pr,
    val cloudsModel: Clouds_Pr,
    val dt: Long,
    val sysModel: Sys_Pr,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,

    ) {
        companion object {}
}
/*fun WeatherList_Pr.Companion.fromModel(weatherlistModel: WeatherList_Model): WeatherList_Pr {
    var t = weatherlistModel.weather
    //TODO А как лучше?
    val listWeather : ArrayList<Weather> = ArrayList<Weather>()
    for (item in t){
        listWeather.add(Weather.fromModel(item))
    }
    return WeatherList_Pr(
        coordModel = weatherlistModel.coordModel,
        weather = TODO(),
        base = TODO(),
        main = TODO(),
        visibility = TODO(),
        wind = TODO(),
        cloudsModel = TODO(),
        dt = TODO(),
        sysModel = TODO(),
        timezone = TODO(),
        id = TODO(),
        name = TODO(),
        cod = TODO()

        *//*        main = Main.fromModel(weatherlistModel.main),
        weather = listWeather,
        name = weatherlistModel.name*//*
    )
}*/
/*fun WeatherList_Pr.Companion.fromModel(weatherList: WeatherList_Model)  = WeatherList_Pr(
    coordModel =  weatherList.coordModel,
    weather = TODO(),
    base = weatherList.base,
    main = TODO(),
    visibility = TODO(),
    wind = TODO(),
    cloudsModel = TODO(),
    dt = TODO(),
    sysModel = TODO(),
    timezone = TODO(),
    id = TODO(),
    name = TODO(),
    cod = TODO()
)*/
/*fun WeatherList_Pr.toModel(): WeatherList_Model {
    // TODO Я бля хуй знает что с TODO делать
    return WeatherList_Model(
        coordModel = coordModel.toModel(),
        weather = TODO(),
        base = base,
        main = main.toModel(),
        visibility = visibility,
        wind = wind.toModel(),
        cloudsModel = cloudsModel.toModel(),
        dt = dt,
        sysModel =  sysModel.toModel(),
        timezone = timezone,
        id = id,
        name = name,
        cod =  cod,
    )
}*/
/*
fun WeatherList_Pr.Companion.fromModel(weatherList: WeatherList_Model): WeatherList_Pr {
    return WeatherList_Pr(
        coordModel = weatherList.coordModel,
        weather = TODO(),
        base = TODO(),
        main = TODO(),
        visibility = TODO(),
        wind = TODO(),
        cloudsModel = TODO(),
        dt = TODO(),
        sysModel = TODO(),
        timezone = TODO(),
        id = TODO(),
        name = TODO(),
        cod = TODO()
    )
}
*/
