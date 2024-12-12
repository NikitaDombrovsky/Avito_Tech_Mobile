package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

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
import kotlin.time.Duration.Companion.days


var topBarCityName_ by mutableStateOf("Пусто")

//var topBarCityName by remember { mutableStateOf("Пусто") } //TODO Ресурсы
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherActivity_F(
    viewModel: WeatherViewModel_F = viewModel()
) {
    val weatherState by viewModel.state.collectAsState()
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            WeatherTopAppBar_F(topBarCityName_)
        }
    ) { innerPadding ->
        WeatherContent_F(weatherState, navController, innerPadding)
    }

    viewModel.fetchWeather("Omsk", "ru")//"4dfc05c3309bcd397630c1c51dda583b")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar_F(cityName: String) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.weather_title, cityName))
        },
        navigationIcon = {
            IconButton(onClick = { /* scope.launch { drawerState.open() } */ }) {
                Icon(Icons.Default.Search, contentDescription = "Меню") //TODO Ресурсы
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
            topBarCityName_ = weatherResponse.name
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
            //WeatherListTest_(weeklyWeatherList)

        }
    }
}
@Composable // TODO Это как бы не компосабл
fun generateWeatherDays_F(
    weeklyWeatherList: WeeklyWeatherList_Pr
): List<WeatherDay> {
    return (0 until weeklyWeatherList.list.size).map { index ->
        WeatherDay(
            dayOfWeek = "День" + index  ,
            weatherIcon = R.drawable.weather_cloudy,
            //temperature = "C" + weeklyWeatherList.list[index].main.temp ,
            temperature = stringResource(
                R.string.weeklyTemperature_text, weeklyWeatherList.list[index].main.temp
            ) ,
            description = weeklyWeatherList.list[index].weather[0].description
        )
    }
}
@Composable
fun WeatherListTest_(
    weeklyWeatherList: WeeklyWeatherList_Pr
) {
    WeeklyWeatherList(weatherDays = generateWeatherDays_(20))
}

fun generateWeatherDays_(count: Int): List<WeatherDay> {
    return (0 until count).map { index ->
        WeatherDay(
            dayOfWeek = "День" + index,
            weatherIcon = R.drawable.weather_cloudy,
            temperature = "25°C",
            description = "Солнечно"
        )
    }
}

/*
@Preview
@Composable
fun PreviewWeatherListTest_() {
    WeatherListTest_()
}*/
