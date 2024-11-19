package com.example.avito_mobile_dombrovskiy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import com.example.avito_mobile_dombrovskiy.TestRetrofit.Weather.RetrofitHelper


import com.example.avito_mobile_dombrovskiy.TestRetrofit.Weather.WeatherApi
import com.example.avito_mobile_dombrovskiy.ui.theme.AppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                RetrofitQuotesTest_()

            }
        }
    }
}
fun RetrofitQuotesTest_(){
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
}
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
@Preview(showBackground = true, wallpaper = Wallpapers.NONE)
@Composable
fun GreetingPreviewTheme() {
    AppTheme() {
        Greeting("Android")
    }
}