package com.example.avito_mobile_dombrovskiy.App


import android.app.Application
import com.example.avito_mobile_dombrovskiy.DI.AppModule
import com.example.avito_mobile_dombrovskiy.DI.DataModule
//import com.example.avito_mobile_dombrovskiy.DI.DataModule
import com.example.avito_mobile_dombrovskiy.DI.DomainModule
/*import com.example.todolist.di.dataModule
import com.example.todolist.di.domainModule*/
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(AppModule, DataModule, DomainModule))
        }
    }
}