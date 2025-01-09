package com.example.avito_mobile_dombrovskiy.DI

import com.example.datamodule.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext

import org.koin.dsl.module

val DataModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl() }
}


