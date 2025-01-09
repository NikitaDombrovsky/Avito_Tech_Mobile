package com.example.avito_mobile_dombrovskiy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.avito_mobile_dombrovskiy.ui.theme.AppTheme
import com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities.WeatherActivity_F
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val vm: WeatherViewModel_F by viewModel<WeatherViewModel_F>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                vm.reduce(WeatherEvent_.Loading)
                WeatherActivity_F()
            }
        }
    }
}
