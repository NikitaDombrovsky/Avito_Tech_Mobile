package com.example.datamodule.repository


import android.util.Log
import com.example.datamodule.BuildConfig
import com.example.datamodule.storage.CurrentWeather.toModel
import com.example.datamodule.RetrofitWeather.RetrofitClient
import com.example.datamodule.storage.WeeklyWeather.toModel
import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.WeeklyWeather.WeeklyWeather_Model
import com.example.domain.repository.WeatherRepository

import java.io.File
import java.io.FileInputStream
import java.util.Properties

class WeatherRepositoryImpl() : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherList_Model {
        // RetrofitHelper.getInstance()
        // TODO Вынести RetrofitClient в принимаемые
        //val test = BuildConfig.WAPI_KEY
        //Log.e("APIKEY", getApiKey())
        //val apiKey =  ""//BuildConfig.API_KEY//BuildConfig.API_KEY//com.google.android.secrets.BuildConfig.API_KEY
        val test = (RetrofitClient.weatherService.getWeather(
           // city = "Omsk",
            city = city,
            //apiKey = "4dfc05c3309bcd397630c1c51dda583b",
            apiKey = BuildConfig.WAPI_KEY,
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
/*    fun getApiKey(): String {
        val properties = Properties()
        val localProperties = File("${System.getProperty("user.dir")}/local.properties")
        val localProperties_ = File("/local.properties")
        if (localProperties.exists()) {
            properties.load(localProperties.inputStream())
        } else {
            throw FileNotFoundException("local.properties file not found")
        }
        return properties.getProperty("API_KEY", "")
    }*/
    fun getApiKey_(): String {
/*        var localProperties_ = Properties()
        localProperties_.load(FileInputStream(rootProject.file("local.properties")))*/

/*        Properties properties = new Properties()
        properties.load(project.rootProject.file('local.properties').newDataInputStream())
        def sdkDir = properties.getProperty('sdk.dir')
        def ndkDir = properties.getProperty('ndk.dir')*/

        val localProperties = Properties()
        localProperties.load(FileInputStream(File("local.properties")))
        val properties = Properties()
/*        val pr = System.getProperty("user.dir")
        val localProperties = File(pr, "local.properties")
        if (localProperties.exists()) {
            properties.load(localProperties.inputStream())
        }*/
        return properties.getProperty("API_KEY", "")
    }

    override suspend fun getWeeklyWeather(city: String): WeeklyWeather_Model {
        val test_ = (RetrofitClient.weeklyWeatherService.getWeeklyWeather_(
            city = "Omsk",
            apiKey = BuildConfig.WAPI_KEY,
            language = "ru",
            units = "metric"

        ))//.map { weather -> weather.toModel() }
        Log.e("!", "" + test_)
        val t1s = test_
        val test = (RetrofitClient.weeklyWeatherService.getWeeklyWeather_(
            city = "Omsk",
            apiKey = BuildConfig.WAPI_KEY,
            language = "ru",
            units = "metric"

        )).toModel()
        return  test
        TODO("Not yet implemented")
    }
/*    override suspend fun getWeeklyWeather(city: String): List<WeeklyWeatherList_Model> {
        val test_ = (RetrofitClient.weeklyWeatherService.getWeeklyWeather_(
            city = "Omsk",
            apiKey = BuildConfig.WAPI_KEY,
            language = "ru",
            units = "metric"

        ))//.map { weather -> weather.toModel() }
        Log.e("!", "" + test_)
        val t1s = test_
        val test = (RetrofitClient.weeklyWeatherService.getWeeklyWeather(
            city = "Omsk",
            apiKey = BuildConfig.WAPI_KEY,
            language = "ru",
            units = "metric"

        )).map { weather -> weather.toModel() }
        return  test
        TODO("Not yet implemented")
    }*/
/*    override suspend fun getAllTasks(): List<TaskModel> {
        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }
    }*/
}