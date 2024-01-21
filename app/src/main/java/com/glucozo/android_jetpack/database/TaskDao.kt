package com.glucozo.android_jetpack.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.glucozo.android_jetpack.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // bi xung doi Id thi bo cai cu di, them cai moi
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM task WHERE task_id = :id")
    suspend fun deleteTaskById(id: Int)

    @Query("DELETE FROM task")
    suspend fun deleteAllTask()

    // tat ca cac thao tac o database khong duoc chay tren main Thread
    @Query("SELECT * FROM task")
//    fun getAllTask(): List<Task>
    suspend fun getAllTask(): List<Task> // su dung suspend de tao coroutines

    @Query("SELECT * FROM task")
    fun getAllTaskLiveData(): LiveData<List<Task>>

    @Query("SELECT * FROM task")
    fun getAllTaskFlow(): Flow<List<Task>>
}