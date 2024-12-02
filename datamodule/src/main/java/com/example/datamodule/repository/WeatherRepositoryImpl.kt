package com.example.datamodule.repository


import com.example.datamodule.storage.CurrentWeather.toModel
import com.example.datamodule.RetrofitWeather.RetrofitClient
import com.example.datamodule.storage.WeeklyWeather.toModel
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.WeeklyWeather.WeeklyWeatherList_Model
import com.example.domain.repository.WeatherRepository

class WeatherRepositoryImpl() : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherList_Model {
        // RetrofitHelper.getInstance()
        // TODO Вынести RetrofitClient в принимаемые
        val test = (RetrofitClient.weatherService.getWeather(
            city = "Omsk",
            apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            language = "ru",
            units = "metric"

        )).toModel()
        return  test
/*        return (RetrofitClient.weatherService.getWeather(
            city = "Omsk",
            apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            language = "ru",
            units = "metric"

        )).toModel()*/
    }

    override suspend fun getWeeklyWeather(city: String): List<WeeklyWeatherList_Model> {
        val test = (RetrofitClient.weatherService.getWeeklyWeather(
            city = "Omsk",
            apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            language = "ru",
            units = "metric"

        )).map { weather -> weather.toModel() }
        return  test
        TODO("Not yet implemented")
    }
/*    override suspend fun getAllTasks(): List<TaskModel> {
        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }
    }*/
}