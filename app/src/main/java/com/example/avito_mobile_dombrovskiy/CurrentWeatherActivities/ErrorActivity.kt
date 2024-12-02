package com.example.avito_mobile_dombrovskiy.CurrentWeatherActivities

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorActivity(errorMessage: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $errorMessage", color =  MaterialTheme.colorScheme.error)
        Log.wtf("Error:", errorMessage)
    }
}