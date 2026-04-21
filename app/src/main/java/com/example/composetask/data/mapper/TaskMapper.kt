package com.example.composetask.data.mapper

import com.example.composetask.data.local.TaskEntity
import com.example.composetask.data.remote.Task


fun TaskEntity.toDomain(): Task {
    return Task(
        id = id,
        title = title,
        isCompleted = isCompleted
    )
}

fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        isCompleted = isCompleted
    )
}

