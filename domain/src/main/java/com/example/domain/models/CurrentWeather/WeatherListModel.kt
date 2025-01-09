package com.example.domain.models.CurrentWeather

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Suppress("NewApi")
fun LocalDateTime.formatToDisplayString(): String {
    val dayOfWeek = this.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
    val time = this.hour
    return "$dayOfWeek | $time часов"
}

@Suppress("NewApi", "SuspiciousIndentation")
data class WeatherListModel(
    val weather: List<WeatherModel>,
    val main: MainModel,
    val name: String,
    var dt_txt: String
) {
    init {
        if (dt_txt == "") dt_txt else
            dt_txt = LocalDateTime.parse(
                dt_txt,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            )
                .formatToDisplayString()
    }
}
/*class WeatherList_Model {
    val weather: List<WeatherModel>
    val main: Main_Model
    val name: String
    val dt_txt: String

    constructor(
        _weather: List<WeatherModel>,
        _main: Main_Model,
        _name: String,
        _dt_txt: String
    ) {
        this.weather = _weather
        this.main = _main
        this.name = _name
        this.dt_txt = formatDate(_dt_txt)
    }

}

@Suppress("NewApi")
private fun formatDate(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateString, formatter)

    val dayOfWeek = dateTime.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
    val time = dateTime.hour

    return "$dayOfWeek | $time часов"
}*/
