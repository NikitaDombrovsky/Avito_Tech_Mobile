package com.example.avito_mobile_dombrovskiy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
/*import com.example.avito_mobile_dombrovskiy.TestRetrofit.Weather.RetrofitHelper
import com.example.avito_mobile_dombrovskiy.TestRetrofit.Weather.WeatherApi*/
import com.example.avito_mobile_dombrovskiy.ui.theme.AppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                WeatherApp()
  /*              Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Weather App") }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }


                RetrofitQuotesTest_()*/

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp(viewModel: WeatherViewModel = viewModel()) {
    val weatherState by viewModel.weatherState.collectAsState()
    var topBarCityName by remember { mutableStateOf("Саси")}
        Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Погода в $topBarCityName") }
            )
        }
    ) { innerPadding ->
        when (weatherState) {
            is WeatherState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
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
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error: $errorMessage")
                }
            }
        }
    }

    // Fetch weather data when the app starts
    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
}
/*fun RetrofitQuotesTest_(){
    val quotesApi = RetrofitHelper.getInstance().create(WeatherApi::class.java)
    // launching a new coroutine
    GlobalScope.launch {
        val result = quotesApi.getWeather()
        if (result != null)
        // Checking the results
            Log.d("Retrofit: ", result.body().toString())
        else{
            Log.d("Retrofit: ", "данные где?")
        }
    }
}*/
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}

/* @Preview(showBackground = true, wallpaper = Wallpapers.NONE)
@Composable
fun GreetingPreviewTheme() {
    AppTheme() {
        Greeting("Android")
    }
}*/


/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp()
        }
    }
}*/

/*fun RetrofitQuotesTest(){
    val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
    // launching a new coroutine
    GlobalScope.launch {
        val result = quotesApi.getQuotes()
        if (result != null)
        // Checking the results
            Log.d("ayush: ", result.body().toString())
    }
}*/