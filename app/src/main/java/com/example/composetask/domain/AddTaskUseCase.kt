package com.example.composetask.domain

import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(){
        return repository.sync()
    }
}