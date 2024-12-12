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

/*    // TODO suspend
    suspend fun fetchWeeklyWeather(city: String, apiKey: String) {

        getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
        viewModelScope.launch {
            try {
                _state.tryEmit(
                    WeatherUIState_.Success(
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
        viewModelScope.launch {
            try {
                val t1 = WeatherResponse.fromModel(getCurrentWeatherUseCase(city))
                //val t2 = getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
                val t2 = WeeklyWeatherList_Pr.fromModel(getWeeklyWeatherUseCase(city))
                //val t2 = getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
                Log.e("ИЗДЕЦ", "t1:" + t1 + "t2:" + t2)
                _state.value =
                    WeatherUIState_.Success(
                        WeatherResponse.fromModel(getCurrentWeatherUseCase(city)),
                       // getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
                        WeeklyWeatherList_Pr.fromModel(getWeeklyWeatherUseCase(city))
                        //getWeeklyWeatherUseCase(city).map {data -> WeeklyWeatherList_Pr.fromModel(data)}
                    )
                Log.e("!", "!")
            } catch (e: Exception) {
                _state.value = WeatherUIState_.Error(e.message ?: "Unknown error")
            }
        }
    }

    init {
        Log.e("!", "VM created")
    }

    override fun onCleared() {
        Log.e("!", "VM cleared")
        super.onCleared()
    }
}

sealed class WeatherUIState_ : UiState {
    object Loading : WeatherUIState_()
    //data class Success(val weatherResponse: WeatherResponse, val weatherList: List<WeeklyWeatherList_Pr>) : WeatherUIState_()
    data class Success(val weatherResponse: WeatherResponse, val weeklyWeatherResponse: WeeklyWeatherList_Pr) : WeatherUIState_()
   // data class Success(val weatherResponse: WeatherResponse) : WeatherUIState_()
    data class Error(val message: String) : WeatherUIState_()
}

sealed interface WeatherEvent_ : UiEvent {

    object Loading : WeatherEvent_
    data class Success(val weatherResponse: WeatherEntity) : WeatherEvent_
    data class Error(val message: String) : WeatherEvent_



}