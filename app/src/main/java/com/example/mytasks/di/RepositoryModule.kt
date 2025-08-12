package com.example.mytasks.di

import com.example.mytasks.data.repositoryImpl.TaskRepositoryImpl
import com.example.mytasks.domain.repository.RepositoryTask
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindTaskRepositoryImpl(impl: TaskRepositoryImpl): RepositoryTask

}