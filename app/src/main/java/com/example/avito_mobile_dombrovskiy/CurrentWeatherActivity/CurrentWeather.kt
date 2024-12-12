package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivity

/*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp(viewModel: WeatherViewModel_ = viewModel()) {
    val weatherState by viewModel.state.collectAsState()
    var topBarCityName by remember { mutableStateOf("Саси") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Погода в $topBarCityName") }
            )
        }
    ) { innerPadding ->
        when (weatherState) {
            is WeatherUIState.Loading -> {
                LoadingActivity(Modifier.padding(innerPadding))
*/
/*                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }*//*

            }
 */
/*           is WeatherState.SuccessResponse -> {

            }*//*

            is WeatherUIState.Success -> {
                val weatherResponse = (weatherState as WeatherUIState.Success).weatherResponse
                topBarCityName = weatherResponse.name
                CurrentWeatherActivity(weatherResponse)

*/
/*                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Temperature: ${weatherResponse.main.temp}°C")
                    Text(text = "Humidity: ${weatherResponse.main.humidity}%")
                    Text(text = "Description: ${weatherResponse.weather[0].description}")

                }*//*


            }

            is WeatherUIState.Error -> {
                val errorMessage = (weatherState as WeatherUIState.Error).message
                ErrorActivity(errorMessage)
*/
/*                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Error: $errorMessage")
                }*//*


            }

            is WeatherUIState.WeeklySuccess -> TODO()
        }
    }

    // Fetch weather data when the app starts
    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
}
*/
