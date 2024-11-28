
package com.example.avito_mobile_dombrovskiy.DI

/*import com.example.todolist.data.Final.repositoty.DatabaseRepository
import com.example.todolist.data.Final.repositoty.TaskRepositoryImpl

import com.example.todolist.domain.Final.repository.TaskRepositoryFinal*/
import com.example.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext

import org.koin.dsl.module

val DataModule = module {
    single<WeatherRepository> { TaskRepositoryImpl(taskStorage = get()) }

/*    single { provideDatabase(androidContext()) }
    single{ provideDao(get())}
    factory { DatabaseRepository(get()) }


      single<TaskDatabase> { TaskDatabase_Impl()}

      single<TaskDao> { TaskDao_Impl(get()) }

    single<TaskRepositoryFinal> { TaskRepositoryImpl(taskStorage = get()) }*/


    //single<TaskStorage> { TaskStorageImpl (context = get()) }


}

//private val getTasksUseCase by lazy { GetTasksUseCase(taskRepositoryImpl) }

