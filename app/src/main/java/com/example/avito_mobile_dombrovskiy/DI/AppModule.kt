package com.example.avito_mobile_dombrovskiy.DI


import com.example.avito_mobile_dombrovskiy.TestViewModel
import com.example.avito_mobile_dombrovskiy.WeatherViewModel_

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { TestViewModel() }
/*    viewModel<WeatherViewModel_>(){
        WeatherViewModel_(
            getCurrentWeatherUseCase =  get()
            //getTasksUseCase = get()

        )
    }*/
}