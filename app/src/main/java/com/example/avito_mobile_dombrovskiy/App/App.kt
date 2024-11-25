/*
package com.example.avito_mobile_dombrovskiy.App

import android.app.Application
//import com.example.todolist.presentation.Main.MainActivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp//(MainActivity::class)
class App: Application()*/
package com.example.avito_mobile_dombrovskiy.App


import android.app.Application
import com.example.avito_mobile_dombrovskiy.DI.AppModule
//import com.example.avito_mobile_dombrovskiy.DI.DataModule
import com.example.avito_mobile_dombrovskiy.DI.DomainModule
/*import com.example.todolist.di.dataModule
import com.example.todolist.di.domainModule*/
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

import org.koin.core.context.startKoin
//import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{

            androidLogger(Level.ERROR) //TODO в DEBUG не работает
            androidContext(this@App)
            //modules(listOf(AppModule, DataModule ,DomainModule))
            //modules(listOf(AppModule ,DomainModule))
            modules(listOf(AppModule))
        }
    }

}