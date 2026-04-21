package com.example.composetask.domain

import com.example.composetask.data.remote.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskUseCase @Inject constructor (
    private val repository: TaskRepository
){
    operator  fun invoke(): Flow<List<Task>>{
        return repository.getTasks()
    }
}