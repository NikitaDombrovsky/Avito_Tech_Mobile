package com.example.domain.repository

import com.example.domain.models.CurrentWeather.WeatherList_Model
import com.example.domain.models.WeeklyWeather.WeeklyWeatherList_Model

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherList_Model
    suspend fun getWeeklyWeather(city: String): List<WeeklyWeatherList_Model>
}

/*
import com.example.todolist.domain.models.TaskModel

interface TaskRepository {
    fun getAllTasks(): List<TaskModel>
    fun getTaskDetails(): TaskModel
    fun saveTask(taskModel: TaskModel): Boolean
}*/
