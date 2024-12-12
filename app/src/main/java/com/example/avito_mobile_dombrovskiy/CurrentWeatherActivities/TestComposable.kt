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
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avito_mobile_dombrovskiy.R
import com.example.avito_mobile_dombrovskiy.WeatherResponse
import com.example.avito_mobile_dombrovskiy.WeatherUIState
import com.example.avito_mobile_dombrovskiy.WeatherViewModel_

import com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity.WeatherDay
import com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity.WeeklyWeatherList


var topBarCityName by mutableStateOf("Пусто")
//var topBarCityName by remember { mutableStateOf("Пусто") } //TODO Ресурсы
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherActivity_(
    viewModel: WeatherViewModel_ = viewModel()
) {
    val weatherState by viewModel.state.collectAsState()
    //var topBarCityName by remember { mutableStateOf("Пусто") } //TODO Ресурсы
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            WeatherTopAppBar(topBarCityName)
        }
    ) { innerPadding ->
        //WeatherContent(weatherState, topBarCityName, navController, innerPadding)
        WeatherContent(weatherState, navController, innerPadding)
    }

    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar(cityName: String) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.weather_title, cityName))
                //stringResource(R.string.weather_title) + " " + cityName)
        },
        navigationIcon = {
            IconButton(onClick = { /* scope.launch { drawerState.open() } */ }) {
                Icon(Icons.Default.Search, contentDescription = "Меню") //TODO Ресурсы
            }
        }
    )
}
@Composable
fun WeatherContent(
    weatherState: WeatherUIState,
   // topBarCityName: String,
    navController: NavHostController,
    innerPadding: PaddingValues
) {
   // var cityName by remember { mutableStateOf(topBarCityName) }
    when (weatherState) {
        is WeatherUIState.Loading -> {
            LoadingActivity(Modifier.padding(innerPadding))
        }

        is WeatherUIState.Success -> {
            val weatherResponse = (weatherState as WeatherUIState.Success).weatherResponse
            topBarCityName = weatherResponse.name
          //  cityName = weatherResponse.name
           // topBarCityName.value = weatherResponse.name

            Column(modifier = Modifier.fillMaxSize()) {
                WeatherDraggableBox(navController, weatherResponse)
            }
        }

        is WeatherUIState.Error -> {
            val errorMessage = (weatherState as WeatherUIState.Error).message
            ErrorActivity(errorMessage)
        }

        is WeatherUIState.WeeklySuccess -> TODO()
    }
}

@Composable
fun WeatherDraggableBox(navController: NavHostController, weatherResponse: WeatherResponse) {
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
        WeatherNavHost(navController, weatherResponse)
    }
}
@Composable
fun WeatherNavHost(navController: NavHostController, weatherResponse: WeatherResponse) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            CurrentWeatherActivity(weatherResponse)

        }
        composable("settings") {
           // SecondScreen(navController)
            WeatherListTest()

        }
/*        composable("home") {
            val weatherResponse = (navController.currentBackStackEntry?.arguments?.getParcelable<WeatherResponse>("weatherResponse"))!!
            CurrentWeatherActivity(weatherResponse)
        }
        composable("settings") {
            SecondScreen(navController)
        }*/
    }
}
@Composable
fun WeatherListTest(){

    val weatherDays = listOf(

        WeatherDay(
            dayOfWeek = "Понедельник1",
            weatherIcon = R.drawable.weather_cloudy, // Замените на ваш идентификатор ресурса
            temperature = "25°C",
            description = "Солнечно"
        ),
        WeatherDay(
            dayOfWeek = "Вторник2",
            weatherIcon = R.drawable.weather_cloudy, // Замените на ваш идентификатор ресурса
            temperature = "18°C",
            description = "Облачно"
        )
        // Добавьте остальные дни недели
    )


    WeeklyWeatherList(weatherDays = generateWeatherDays(20))
}
fun generateWeatherDays(count: Int): List<WeatherDay> {
    return (0 until count).map { index ->
        WeatherDay(
            dayOfWeek = "День" + index,
            weatherIcon = R.drawable.weather_cloudy,
            temperature = "25°C",
            description = "Солнечно"
        )
    }
}
@Preview
@Composable
fun PreviewWeatherListTest(){
    WeatherListTest()
}