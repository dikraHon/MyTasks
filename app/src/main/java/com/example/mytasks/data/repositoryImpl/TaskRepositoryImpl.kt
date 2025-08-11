package com.example.mytasks.data.repositoryImpl

import com.example.mytasks.data.database.TaskDatabase
import com.example.mytasks.domain.modelData.ItemTasks
import com.example.mytasks.domain.repository.RepositoryTask
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(getDao: TaskDatabase): RepositoryTask {
    private val taskDao = getDao.taskDao()

    override suspend fun getAllTasks(): Flow<List<ItemTasks>> = taskDao.getAllTasks()

    override suspend fun insert(tasks: ItemTasks) = taskDao.insert(tasks)

    override suspend fun update(tasks: ItemTasks) = taskDao.update(tasks)

    override suspend fun delete(tasks: ItemTasks) = taskDao.delete(tasks)


}