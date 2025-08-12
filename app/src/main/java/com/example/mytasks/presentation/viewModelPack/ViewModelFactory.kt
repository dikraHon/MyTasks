package com.example.mytasks.presentation.viewModelPack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val taskViewModelProvider: Provider<TaskViewModel>,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TaskViewModel::class.java) -> {
                taskViewModelProvider.get() as T
            }
            else -> throw IllegalArgumentException("Unknown Model Class")
        }
    }
}