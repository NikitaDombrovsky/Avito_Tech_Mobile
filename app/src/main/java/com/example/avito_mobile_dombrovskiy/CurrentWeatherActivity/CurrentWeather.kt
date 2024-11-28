package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avito_mobile_dombrovskiy.TestViewModel
import com.example.avito_mobile_dombrovskiy.WeatherState
import com.example.avito_mobile_dombrovskiy.WeatherViewModel_



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp(viewModel: TestViewModel = viewModel()) {
   // val weatherState by viewModel.state.collectAsState()
    var topBarCityName by remember { mutableStateOf("Саси") }

    /*
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Погода в $topBarCityName") }
            )
        }
    ) { innerPadding ->
        when (weatherState) {
            is WeatherState.Loading -> {
                LoadingActivity(Modifier.padding(innerPadding))
/*                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }*/
            }
            is WeatherState.SuccessResponse -> {

            }
            is WeatherState.Success -> {
                val weatherResponse = (weatherState as WeatherState.Success).weatherResponse
                topBarCityName = weatherResponse.name
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Temperature: ${weatherResponse.main.temp}°C")
                    Text(text = "Humidity: ${weatherResponse.main.humidity}%")
                    Text(text = "Description: ${weatherResponse.weather[0].description}")
                }
            }

            is WeatherState.Error -> {
                val errorMessage = (weatherState as WeatherState.Error).message
                ErrorActivity(errorMessage)
/*                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error: $errorMessage")
                }*/
            }


        }
    }

    // Fetch weather data when the app starts
    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")

    */

}
@Composable
fun LoadingActivity(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
@Composable
fun CurrentWeatherActivity(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
@Composable
fun ErrorActivity(errorMessage: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $errorMessage")
    }
}