package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.avito_mobile_dombrovskiy.R
import com.example.avito_mobile_dombrovskiy.WeatherResponse


@Composable
fun CurrentWeatherActivity(weatherResponse: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(
                R.string.temperature_text, weatherResponse.main.temp
            )
        )
        Text(
            text = stringResource(
                R.string.humidity_text, weatherResponse.main.humidity
            )
        )
        Text(
           text = stringResource(
                R.string.description_text, weatherResponse.weather[0].description
            )
        )

    }
}
