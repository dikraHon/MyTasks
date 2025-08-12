package com.example.mytasks.di

import android.app.Application
import android.content.Context
import com.example.mytasks.data.database.TaskDao
import com.example.mytasks.domain.repository.RepositoryTask
import com.example.mytasks.presentation.MainActivity
import com.example.mytasks.presentation.viewModelPack.ViewModelFactory
import dagger.BindsInstance
import dagger.Component


@Component( modules =
    [
        ModuleApp::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance application: Application
        ): AppComponent
    }

    fun inject(activity: MainActivity)
    fun viewModelFactory(): ViewModelFactory
    fun repository(): RepositoryTask
    fun taskDao(): TaskDao

}