package com.example.avito_mobile_dombrovskiy.WeeklyWeatherActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


data class WeatherDay(
    val dayOfWeek: String,
    val weatherIcon: Int, // Идентификатор ресурса иконки
    val temperature: String,
    val description: String
)
@Composable
fun WeatherDayCard(weatherDay: WeatherDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = weatherDay.weatherIcon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
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