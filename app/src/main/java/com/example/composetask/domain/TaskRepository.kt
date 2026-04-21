package com.example.composetask.domain

import com.example.composetask.data.remote.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun sync()
}