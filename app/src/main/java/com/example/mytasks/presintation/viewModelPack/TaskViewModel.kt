package com.example.mytasks.presintation.viewModelPack

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytasks.domain.modelData.ItemTasks
import com.example.mytasks.domain.repository.RepositoryTask
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repositoryTask: RepositoryTask,
    application: Application
) : AndroidViewModel(application) {

    val tasks: StateFlow<List<ItemTasks>> = flow {
        emitAll(repositoryTask.getAllTasks())
    }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun insert(itemTasks: ItemTasks) {
        viewModelScope.launch {
            repositoryTask.insert(itemTasks)
        }
    }

    fun update(itemTasks: ItemTasks) {
        viewModelScope.launch {
            repositoryTask.update(itemTasks)
        }
    }

    fun delete(itemTasks: ItemTasks) {
        viewModelScope.launch {
            repositoryTask.delete(itemTasks)
        }
    }

}