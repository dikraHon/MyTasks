package com.example.mytasks.presentation.mainScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.mytasks.domain.modelData.ItemTasks

@Composable
fun TaskCard(
    itemTasks: ItemTasks,
    onTaskClick: (ItemTasks) -> Unit,
    onDeleteClick: (ItemTasks) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = itemTasks.isCompleted,
                onCheckedChange = {
                    onTaskClick(itemTasks.copy(isCompleted = true))
                }
            )
            Text(
                text = itemTasks.title,
                modifier = Modifier
                    .weight(1f),
                style = if (itemTasks.isCompleted) {
                    MaterialTheme
                        .typography
                        .bodyMedium
                        .copy(textDecoration = TextDecoration.LineThrough)
                } else {
                    MaterialTheme
                        .typography
                        .bodyMedium
                }
            )
            IconButton(
                onClick = {
                    onDeleteClick(itemTasks)
                }
            ) {
                Icon(
                    imageVector = Icons
                        .Default
                        .Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}