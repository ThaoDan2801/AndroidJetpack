package com.glucozo.android_jetpack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.glucozo.android_jetpack.database.TaskDatabase
import com.glucozo.android_jetpack.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(app: Application) : AndroidViewModel(app) {
    private val taskDao = TaskDatabase.getInstance(app.applicationContext).getTaskDao()

    val tasks = taskDao.getAllTaskLiveData() //database changed

    fun insertTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.insertTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.updateTask(task)
        }
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteTaskById(id)
        }
    }
}