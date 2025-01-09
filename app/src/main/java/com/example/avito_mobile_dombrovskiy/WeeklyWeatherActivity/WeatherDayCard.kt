package com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.avito_mobile_dombrovskiy.R


@Composable
fun WeatherDayCard(weatherDay: WeatherDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                15.dp,
                8.dp,
                15.dp,
                8.dp
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .crossfade(true)
                .build()

            AsyncImage(
                //TODO Res
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://openweathermap.org/img/wn/${weatherDay.iconName}@2x.png")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.weather_cloudy),
                contentDescription = stringResource(R.string.locale),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(48.dp),
                imageLoader = imageLoader,
                onError = { error ->
                    Log.e("AsyncImage", "Failed to load image: ${error.result.throwable.message}")
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = weatherDay.dayOfWeek, style = MaterialTheme.typography.titleMedium)
                Text(text = weatherDay.temperature, style = MaterialTheme.typography.bodyLarge)
                Text(text = weatherDay.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

data class WeatherDay(
    val dayOfWeek: String,
    val temperature: String,
    val description: String,
    val iconName: String
)

@Composable
fun WeeklyWeatherList(weatherDays: List<WeatherDay>) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            items(weatherDays) { weatherDay ->
                WeatherDayCard(weatherDay = weatherDay)
            }
        }
    }
}