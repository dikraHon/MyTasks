package com.example.mytasks.presentation.mainScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mytasks.presentation.viewModelPack.TaskViewModel

@Composable
fun ListTasks(
    taskViewModel: TaskViewModel,
    modifier: Modifier = Modifier
) {

    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())

    LazyColumn{
        items(items = tasks) { task ->
            TaskCard(
                itemTasks = task,
                onTaskClick = { taskViewModel.update(itemTasks = it) },
                onDeleteClick = { taskViewModel.delete(itemTasks = it) }
            )
        }
    }

}