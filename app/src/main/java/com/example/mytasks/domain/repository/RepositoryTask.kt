package com.example.mytasks.domain.repository

import com.example.mytasks.domain.modelData.ItemTasks
import kotlinx.coroutines.flow.Flow

interface RepositoryTask {

    suspend fun getAllTasks(): Flow<List<ItemTasks>>

    suspend fun insert(tasks: ItemTasks)

    suspend fun update(tasks: ItemTasks)

    suspend fun delete(tasks: ItemTasks)
}