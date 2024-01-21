package com.glucozo.android_jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @ColumnInfo("task_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo("task_title")
    val name: String = "",
    @ColumnInfo("task_description")
    val description: String = "",
    @ColumnInfo("task_deadline")
    val deadline: String = ""
)
