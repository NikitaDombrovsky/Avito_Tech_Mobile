
package com.example.datamodule.storage.CurrentWeather



import com.example.datamodule.storage.WeeklyWeather.toModel
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.CurrentWeather.Weather_Model



data class WeatherListEntity(
   // val coordModel: CoordEntity, //TODO
    val weather: List<WeatherEntity>,
    val base: String? = "",
    val main: MainEntity,
    val visibility: Long,
    val wind: WindEntity,
   // val cloudsModel: CloudsEntity, //TODO
    val dt: Long,
   // val sysModel: SysEntity, //TODO
    val timezone: Long,
    val id: Long,
    val name: String? = "",
    val cod: Long,

    ) {
    companion object {}
}
fun WeatherListEntity.toModel(): WeatherList_Model{

    //val listWeather: List<Weather_Model> = weather.map { it.toModel() }
/*    val listWeather : ArrayList<Weather_Model> = ArrayList<Weather_Model>()
    for (item in weather){
        listWeather.add(item.toModel())
    }*/
    return WeatherList_Model(
        weather = weather.map { it.toModel() },
        base = if(base != null) base else "",
        main = main.toModel(),
        visibility = visibility,
        wind = wind.toModel(),
        dt = dt,
        timezone = timezone,
        id = id,
        name =if(name != null) name else "" ,
        cod =  cod,
    )
}

// TODO Оно не вызывается
/*
fun WeatherListEntity.Companion.fromModel(weatherList: WeatherList_Model): WeatherListEntity {
    return WeatherListEntity(
        coordModel = TODO(),
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

