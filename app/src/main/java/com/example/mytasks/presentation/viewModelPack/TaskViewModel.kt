package com.example.mytasks.presentation.viewModelPack

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
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    private val repositoryTask: RepositoryTask,
) : ViewModel() {

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