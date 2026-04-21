package com.example.composetask.presentation

import com.example.composetask.data.remote.Task

data class TaskState(
    val isLoading: Boolean = true,
    val tasks: List<Task> = emptyList(),
    var error: String? = null
)