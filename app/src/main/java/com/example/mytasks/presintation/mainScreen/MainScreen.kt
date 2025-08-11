package com.example.mytasks.presintation.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mytasks.domain.modelData.ItemTasks
import com.example.mytasks.presintation.viewModelPack.TaskViewModel

@Composable
fun MainScreen(
    taskViewModel: TaskViewModel,
) {
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog.value = true
                },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons
                        .Default
                        .Add,
                    contentDescription = "Add Task"
                )
            }
        }
    ) { paddingValues ->
        ListTasks(
            taskViewModel,
            modifier = Modifier.padding(paddingValues)
            )

        if (showDialog.value) {
            AddTaskDialog(
                onDismiss = {
                    showDialog.value = false
                },
                onConfirm = { title ->
                    if (title.isNotBlank()) {
                        taskViewModel.insert(ItemTasks(title = title))
                    }
                }
            )
        }
    }
}