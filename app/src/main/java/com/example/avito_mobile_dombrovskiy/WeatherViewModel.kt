package com.example.avito_mobile_dombrovskiy

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avito_mobile_dombrovskiy.Core.UiEvent
import com.example.avito_mobile_dombrovskiy.Core.UiState
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.WeeklyCity_Pr
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.WeeklyWeatherList_Pr
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.fromModel
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.toModel


import com.example.datamodule.storage.CurrentWeather.WeatherEntity

import com.example.domain.usecase.CurrentUseCase.GetCurrentWeatherUseCase
import com.example.domain.usecase.WeeklyUseCase.GetWeeklyWeatherUseCase


import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.intellij.lang.annotations.Language

/*
class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val weatherState: StateFlow<WeatherState> = _weatherState

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.weatherService.getWeather(city, apiKey)
                _weatherState.value = WeatherState.Success(response)
            } catch (e: Exception) {
                _weatherState.value = WeatherState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
*/



class WeatherViewModel_(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeeklyWeatherUseCase: GetWeeklyWeatherUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<WeatherUIState>(WeatherUIState.Loading)
    val state: StateFlow<WeatherUIState> = _state.asStateFlow()

    fun reduce(event: WeatherEvent) {
        when (event) {
            /*            MainEvent.ShowEmpty -> {
                            _state.tryEmit(MainUIState.Empty)

                        }*/
            WeatherEvent.Loading -> {
                _state.tryEmit(WeatherUIState.Loading)
            }

            is WeatherEvent.Success -> {
                /*                viewModelScope.launch {
                                    _state.tryEmit(MainUIState.Tasks(getTasks()))
                                    //getTasks()
                                }*/
            }

            is WeatherEvent.Error -> {


            }
            /*            WeatherEvent.HideDialog -> TODO()

                        WeatherEvent.ShowDialog -> TODO()*/

        }
    }
/*
    // TODO suspend
    suspend fun fetchWeeklyWeather(city: String, apiKey: String) {
        getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
        viewModelScope.launch {
            try {
                _state.tryEmit(
                    WeatherUIState.WeeklySuccess(
                        getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
                    )
                )
            } catch (e: Exception) {
                _state.value = WeatherUIState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }*/

    // TODO suspend
    fun fetchWeather(city: String, language: String){//}, apiKey: String) {
        //getCurrentWeatherUseCase//().map { weather ->  }
        viewModelScope.launch {
            try {
                _state.value =
                    WeatherUIState.Success(WeatherResponse.fromModel(getCurrentWeatherUseCase(city)))
            } catch (e: Exception) {
                _state.value = WeatherUIState.Error(e.message ?: "Unknown error")
            }
        }

        /*
                getTasksUseCase().map {tasks -> TaskPreviewView(
            id = tasks.id,
            title = tasks.title,
            deadline = tasks.deadline,
            changedAt = tasks.changedAt,
            checkedStatus = tasks.checkedStatus,
            colorOfCategory = tasks.colorOfCategory)
        }
        */

        /*        viewModelScope.launch {
                    try {
                        val response = RetrofitClient.weatherService.getWeather(city, apiKey)
                        _state.value = WeatherState.SuccessResponse(response)
                    } catch (e: Exception) {
                        _state.value = WeatherState.Error(e.message ?: "Unknown error")
                    }
                }*/
    }


    init {
        Log.e("!", "VM created")
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }
}

sealed class WeatherUIState : UiState {
    object Loading : WeatherUIState()
    data class Success(val weatherResponse: WeatherResponse) : WeatherUIState()
    data class WeeklySuccess(val weatherList: List<WeeklyWeatherList_Pr>) : WeatherUIState()

    //data class Success(val weatherResponse: WeatherEntity) : WeatherState()
    // data class SuccessResponse(val weatherResponse: WeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherUIState()
}

sealed interface WeatherEvent : UiEvent {

    object Loading : WeatherEvent
    data class Success(val weatherResponse: WeatherEntity) : WeatherEvent
    data class Error(val message: String) : WeatherEvent

    /*    // TODO Заглушка
        object ShowDialog: WeatherEvent
        object HideDialog: WeatherEvent*/


}