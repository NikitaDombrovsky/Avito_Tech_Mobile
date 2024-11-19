package com.example.data.storage

// TODO Здесь Entity или модели ?
data class WeatherListEntity(
    val coord: CoordEntity,
    val weather: List<WeatherEntity>,
    val base: String,
    val main: MainEntity,
    val visibility: Long,
    val wind: WindEntity,
    val clouds: CloudsEntity,
    val dt: Long,
    val sys: SysEntity,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,

    ) {
    companion object {}
}
/*fun WeatherListEntity.toModel(): WeatherList{
    return WeatherList(
        coord = coord,
        weather = weather,
        base = base,
        main = main,
        visibility = visibility,
        wind = wind,
        clouds = clouds,
        dt = dt,
        sys =  sys,
        timezone = timezone,
        id = id,
        name = name,
        cod =  cod,
    )
}
fun TaskEntity.Companion.fromModel(taskModel: TaskModel): TaskEntity {
    return TaskEntity(taskModel.id, taskModel.text, taskModel.title, taskModel.color)
}*/
/*

fun WeatherList.toModel() : WeatherList {
    return WeatherList()
}*/
