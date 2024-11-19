package com.example.domain.repository

import com.example.domain.models.CurrentWeather.WeatherList

interface WeatherRepository {
    fun getCurrentWeather(): List<WeatherList>
}

/*
import com.example.todolist.domain.models.TaskModel

interface TaskRepository {
    fun getAllTasks(): List<TaskModel>
    fun getTaskDetails(): TaskModel
    fun saveTask(taskModel: TaskModel): Boolean
}*/
