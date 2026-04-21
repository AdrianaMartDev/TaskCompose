package com.example.composetask.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val isCompleted: Boolean
)