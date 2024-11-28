package com.example.datamodule.repository

import com.example.data.storage.toModel
import com.example.datamodule.Retrofit.RetrofitClient
import com.example.datamodule.storage._WeatherRealization
import com.example.domain.models.CurrentWeather.WeatherList
import com.example.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val weatherRealization: _WeatherRealization) :
    WeatherRepository {
    /*    override suspend fun getCurrentWeather(): WeatherList {
            //TODO Че бля
            *//*return RetrofitClient.weatherService.getWeather(city = "Omsk", apiKey = "Test")
        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }*//*
        return weatherRealization.getCurrentWeather()
    }*/
    override suspend fun getCurrentWeather(): WeatherList =
        weatherRealization.getCurrentWeather().toModel()

}
//class TaskRepositoryImpl(private val taskStorage: TaskDao): TaskRepositoryFinal {
//    override suspend fun getAllTasks(): List<TaskModel> {
//        return taskStorage.getAllTasks().map { taskGettingDTO -> taskGettingDTO.toModel() }
//    }
//
//    override fun getTaskDetails(id: Int): TaskModel {
//        TODO("Not yet implemented")
//    }
//
//    override fun upsertTask(taskModel: TaskModel) {
//        TODO("Not yet implemented")
//    }
///*    override fun getAllTasks(): List<TaskModel_> =
//        taskStorage.getAllTasks().map { taskEntity -> taskEntity.toModel()}
//
//    override fun getTaskDetails(id :Int): TaskModel_ =
//        taskStorage.getTaskDetails(id).toModel()
//
//    override fun upsertTask(taskModel: TaskModel_) {
//        taskStorage.upsertTask(TaskEntity_.fromModel(taskModel))
//    }
//
//    *//*    override fun saveTask(taskModel: TaskModel_): Boolean =
//            taskStorage.save(TaskEntity.fromModel(taskModel))*/
//
//}
//