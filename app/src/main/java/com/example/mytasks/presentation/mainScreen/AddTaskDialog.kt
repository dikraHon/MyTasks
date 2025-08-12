package com.example.mytasks.presentation.mainScreen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

@Composable
fun AddTaskDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {

    val taskTitle = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("New task")
        },
        text = {
            OutlinedTextField(
                value = taskTitle.value,
                onValueChange = {
                    taskTitle.value = it
                },
                label = {
                    Text("Enter task")
                },
                modifier = Modifier.focusRequester(focusRequester)
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(taskTitle.value)
                    onDismiss()
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Cansel")
            }
        }
    )

}