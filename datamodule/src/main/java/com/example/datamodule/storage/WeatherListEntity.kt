package com.example.datamodule.storage



import android.util.Log
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.CurrentWeather.Weather_Model


data class WeatherListEntity(
   // val coordModel: CoordEntity, //TODO
    val weather: List<WeatherEntity>,
    val base: String,
    val main: MainEntity,
    val visibility: Long,
    val wind: WindEntity,
   // val cloudsModel: CloudsEntity, //TODO
    val dt: Long,
   // val sysModel: SysEntity, //TODO
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,

    ) {
    companion object {}
}
fun WeatherListEntity.toModel(): WeatherList_Model{
    // TODO Я бля хуй знает что с TODO делать
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
/*fun WeatherListEntity.toModel(): WeatherList_Model{
  // TODO Я бля хуй знает что с TODO делать
    val listWeather : ArrayList<Weather_Model> = ArrayList<Weather_Model>()
    for (item in weather){
        listWeather.add(item.toModel())
    }
    return WeatherList_Model(
        coordModel = coordModel.toModel(),
        weather = listWeather,
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
// TODO Я не понимаю как вызвать fromModel
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

