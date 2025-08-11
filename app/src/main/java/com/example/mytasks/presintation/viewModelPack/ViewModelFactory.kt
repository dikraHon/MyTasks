package com.example.mytasks.presintation.viewModelPack

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytasks.domain.repository.RepositoryTask

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val application: Application,
    private val repositoryTask: RepositoryTask
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(
            application = application,
            repositoryTask = repositoryTask
        ) as T
    }
}