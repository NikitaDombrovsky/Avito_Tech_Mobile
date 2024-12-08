package com.example.avito_mobile_dombrovskiy

import android.content.pm.ApplicationInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.example.avito_mobile_dombrovskiy.ui.theme.AppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities.CurrentWeatherActivity
import com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities.ErrorActivity
import com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities.LoadingActivity
import com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities.WeatherActivity_
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import java.util.Properties

class MainActivity : ComponentActivity() {
    private val vm: WeatherViewModel_ by viewModel<WeatherViewModel_>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                vm.reduce(WeatherEvent.Loading)
                    //vm.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
                WeatherActivity_()

                //val apiKey = BuildConfig.API_KEY
/*                CompositionLocalProvider(LocalCounter provides counterState) {
                    MyScreen()
                }*/
            }
        }
    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherActivty(
    viewModel: WeatherViewModel_ = viewModel()
) {
    val weatherState by viewModel.state.collectAsState()
    var topBarCityName by remember { mutableStateOf("Пусто") } //TODO Ресурсы
    val navController = rememberNavController()
    /*    val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()*/

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text( stringResource(R.string.weather_title) + " "+ topBarCityName
                    )
                        }, //TODO Ресурсы
                navigationIcon = {
                    IconButton(onClick = {/* scope.launch { drawerState.open() }*/ }) {
                        Icon(Icons.Default.Search, contentDescription = "Меню") //TODO Ресурсы
                    }
                }
            )
        }
    ) { innerPadding ->
        when (weatherState) {
            is WeatherUIState.Loading -> {
                LoadingActivity(Modifier.padding(innerPadding))
            }

            is WeatherUIState.Success -> {

                val weatherResponse = (weatherState as WeatherUIState.Success).weatherResponse
                topBarCityName = weatherResponse.name

                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier

                            //.size(10.dp)
                            //.fillMaxSize()
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
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                CurrentWeatherActivity(weatherResponse)

                            }
                            composable("settings") {
                                SecondScreen(navController)
                            }
                        }
                    }
                }
            }

            is WeatherUIState.Error -> {
                val errorMessage = (weatherState as WeatherUIState.Error).message
                ErrorActivity(errorMessage)
            }

            is WeatherUIState.WeeklySuccess -> TODO()
        }
    }

    //viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
    // TODO Получать language из конфигурации
    viewModel.fetchWeather("Omsk", stringResource(R.string.locale))
    //viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")


}

/*
var topBarCityName = compositionLocalOf { mutableStateOf("Пусто") }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUIActivity(
    viewModel: WeatherViewModel_ = viewModel()
) {
    val weatherState by viewModel.state.collectAsState()
    //var topBarCityName by remember { mutableStateOf("Пусто") } //TODO Ресурсы
    val navController = rememberNavController()
    */
/*    val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()*//*


    Scaffold(
        topBar = {
            MainTopAppBar()
*/
/*            TopAppBar(
                title = {
                    Text( stringResource(R.string.weather_title) + " "+ topBarCityName
                    )
                }, //TODO Ресурсы
                navigationIcon = {
                    IconButton(onClick = {*//*
*/
/* scope.launch { drawerState.open() }*//*
*/
/* }) {
                        Icon(Icons.Default.Search, contentDescription = "Меню") //TODO Ресурсы
                    }
                }
            )*//*

        }
    ) { innerPadding ->
        Test(Modifier.padding(innerPadding), weatherState)
    }
    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")
    //viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(){
    val counter = topBarCityName.current
    TopAppBar(
        //TODO Ресурсы
        {
            Text( stringResource(R.string.weather_title) + " "+ counter
            )
        }, navigationIcon = {
            IconButton(onClick = {*/
/* scope.launch { drawerState.open() }*//*
 }) {
                Icon(Icons.Default.Search, contentDescription = "Меню") //TODO Ресурсы
            }
        }
    )
}
@Composable
fun Test(padding: Modifier, weatherState: WeatherUIState) {
    var counter = topBarCityName.current
    when (weatherState) {
        is WeatherUIState.Loading -> {
            LoadingActivity()
        }

        is WeatherUIState.Success -> {

            val weatherResponse = (weatherState as WeatherUIState.Success).weatherResponse
            counter = weatherResponse.name

            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier

                        //.size(10.dp)
                        //.fillMaxSize()
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
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            CurrentWeatherActivity(weatherResponse)

                        }
                        composable("settings") {
                            SecondScreen(navController)
                        }
                    }
                }
            }
        }

        is WeatherUIState.Error -> {
            val errorMessage = (weatherState as WeatherUIState.Error).message
            ErrorActivity(errorMessage)
        }

        is WeatherUIState.WeeklySuccess -> TODO()
    }
}
*/




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