package com.example.mytasks.di

import android.app.Application

class AppMyTasks: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(context = this, application = this)
    }
}