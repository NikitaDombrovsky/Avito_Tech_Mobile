package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avito_mobile_dombrovskiy.R
import com.example.avito_mobile_dombrovskiy.WeatherResponse
import com.example.avito_mobile_dombrovskiy.WeatherUIState_
import com.example.avito_mobile_dombrovskiy.WeatherViewModel_F
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity.WeatherDay
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity.WeeklyWeatherList
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherTest.WeeklyWeatherList_Pr
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


var topBarCityName_ by mutableStateOf("London")

@Composable
fun WeatherActivity_F(
    viewModel: WeatherViewModel_F = viewModel()
) {
    val weatherState by viewModel.state.collectAsState()
    val navController = rememberNavController()


    Scaffold(
        topBar = {
            WeatherTopAppBar_WithDynamicTextField_F()
        }
    ) { innerPadding ->
        WeatherContent_F(weatherState, navController, innerPadding)
    }
    setDefaultValue(viewModel)
}

fun setDefaultValue(
    viewModel: WeatherViewModel_F
) {
    viewModel.setCity(topBarCityName_)
    viewModel.setLanguage("ru")
    viewModel.fetchWeather_F()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar_WithDynamicTextField_F(
) {

    var isTextFieldVisible by remember { mutableStateOf(false) }
    //TODO Вынести стейт наверх
    var cityName by remember { mutableStateOf("") }
    TopAppBar(
        title = {
            if (isTextFieldVisible) {
                TextField(

                    value = cityName,
                    onValueChange = { cityName = it },
                    label = { Text(stringResource(R.string.weather_title, topBarCityName_)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            isTextFieldVisible = false;
                            topBarCityName_ = cityName
                        }
                    )
                )
            } else {
                Text(stringResource(R.string.weather_title, topBarCityName_))
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    isTextFieldVisible = !isTextFieldVisible
                }
            ) {
                Icon(
                    imageVector = if (isTextFieldVisible) Icons.Default.Close else Icons.Default.Search,
                    contentDescription = if (isTextFieldVisible) "Закрыть" else "Поиск"
                )
            }
        }
    )
}

@Composable
fun WeatherContent_F(
    weatherState: WeatherUIState_,
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    when (weatherState) {
        is WeatherUIState_.Loading -> {
            LoadingActivity(Modifier.padding(innerPadding))
        }

        is WeatherUIState_.Success -> {
            val weatherResponse = (weatherState as WeatherUIState_.Success).weatherResponse

            // TODO need fix
            // topBarCityName_ = weatherResponse.name
            val weeklyWeather = (weatherState as WeatherUIState_.Success).weeklyWeatherResponse

            Column(modifier = Modifier.fillMaxSize()) {
                WeatherDraggableBox_(
                    navController,
                    weatherResponse,
                    weeklyWeather
                )
            }

        }

        is WeatherUIState_.Error -> {
            val errorMessage = (weatherState as WeatherUIState_.Error).message
            ErrorActivity(errorMessage)
        }
    }
}

@Composable
fun WeatherDraggableBox_(
    navController: NavHostController,
    weatherResponse: WeatherResponse,
    weeklyWeather: WeeklyWeatherList_Pr
) {
    Box(
        modifier = Modifier
            .draggable(
                // TODO need fix
                state = rememberDraggableState { delta ->
                    if (delta > 0) {
                        navController.navigate("home")
                    } else if (delta < 0) {
                        navController.navigate("settings")
                    }
                },
                orientation = Orientation.Horizontal
            )
    ) {
        WeatherNavHost_(
            navController,
            weatherResponse,
            weeklyWeather
        )
    }
}

@Composable
fun WeatherNavHost_(
    navController: NavHostController,
    weatherResponse: WeatherResponse,
    weeklyWeather: WeeklyWeatherList_Pr
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            CurrentWeatherActivity(weatherResponse)

        }
        composable("settings") {
            WeeklyWeatherList(weatherDays = generateWeatherDays_F(weeklyWeather))

        }
    }
}

@Composable
fun generateWeatherDays_F(
    weeklyWeatherList: WeeklyWeatherList_Pr
): List<WeatherDay> {
    return weeklyWeatherList.list.map { weatherData ->
        WeatherDay(
            dayOfWeek = weatherData.dt_txt,
            temperature = stringResource(R.string.weeklyTemperature_text, weatherData.main.temp),
            description = weatherData.weather[0].description,
            iconName = weatherData.weather[0].icon
        )
    }
}
