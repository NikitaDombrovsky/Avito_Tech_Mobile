package com.example.avito_mobile_dombrovskiy


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avito_mobile_dombrovskiy.Core.UiEvent
import com.example.avito_mobile_dombrovskiy.Core.UiState
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.WeeklyWeatherList_Pr
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.fromModel
import com.example.datamodule.storage.CurrentWeather.WeatherEntity
import com.example.domain.usecase.CurrentUseCase.GetCurrentWeatherUseCase
import com.example.domain.usecase.WeeklyUseCase.GetWeeklyWeatherUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class WeatherViewModel_F(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeeklyWeatherUseCase: GetWeeklyWeatherUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<WeatherUIState_>(WeatherUIState_.Loading)
    val state: StateFlow<WeatherUIState_> = _state.asStateFlow()

    private val _currentCity = MutableStateFlow("")
    val currentCity: StateFlow<String> get() = _currentCity.asStateFlow()
    private val _currentLanguage = MutableStateFlow("")
    val currentLanguage: StateFlow<String> get() = _currentLanguage.asStateFlow()
    fun setCity(city: String) {
        _currentCity.value = city
    }

    fun setLanguage(city: String) {
        _currentLanguage.value = city
    }

    fun reduce(event: WeatherEvent_) {
        when (event) {

            WeatherEvent_.Loading -> {
                _state.tryEmit(WeatherUIState_.Loading)
            }

            is WeatherEvent_.Success -> {
            }

            is WeatherEvent_.Error -> {


            }
        }
    }

    fun fetchWeather_F() {
        viewModelScope.launch {
            try {
                _state.value =
                    WeatherUIState_.Success(
                        WeatherResponse.fromModel(
                            getCurrentWeatherUseCase(
                                currentCity.value,
                                currentLanguage.value
                            )
                        ),

                        WeeklyWeatherList_Pr.fromModel(
                            getWeeklyWeatherUseCase(
                                currentCity.value,
                                currentLanguage.value
                            )
                        )
                    )
                Log.e("!", "!")
            } catch (e: Exception) {
                _state.value = WeatherUIState_.Error(e.message ?: "Unknown error")
            }
        }
    }

    init {
        Log.e("!VM", "VM created")
    }

    override fun onCleared() {
        Log.e("!VM", "VM cleared")
        super.onCleared()
    }
}

sealed class WeatherUIState_ : UiState {
    object Loading : WeatherUIState_()
    data class Success(
        val weatherResponse: WeatherResponse,
        val weeklyWeatherResponse: WeeklyWeatherList_Pr
    ) : WeatherUIState_()

    data class Error(val message: String) : WeatherUIState_()
}

sealed interface WeatherEvent_ : UiEvent {

    object Loading : WeatherEvent_
    data class Success(val weatherResponse: WeatherEntity) : WeatherEvent_
    data class Error(val message: String) : WeatherEvent_
}