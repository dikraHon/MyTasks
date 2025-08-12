package com.example.mytasks.di

import android.content.Context
import com.example.mytasks.data.database.TaskDatabase
import dagger.Module
import dagger.Provides

@Module
class ModuleApp {

    @Provides
    fun providesDatabase(context: Context): TaskDatabase = TaskDatabase.Companion.getDatabase(context)

    @Provides
    fun providesTaskDao(database: TaskDatabase) = database.taskDao()
}