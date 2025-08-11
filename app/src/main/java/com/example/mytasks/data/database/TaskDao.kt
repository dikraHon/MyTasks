package com.example.mytasks.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mytasks.domain.modelData.ItemTasks
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(tasks: ItemTasks)

    @Update
    suspend fun update(tasks: ItemTasks)

    @Delete
    suspend fun delete(tasks: ItemTasks)

    @Query("SELECT * FROM tasks ORDER BY priority DESC")
    fun getAllTasks(): Flow<List<ItemTasks>>
}