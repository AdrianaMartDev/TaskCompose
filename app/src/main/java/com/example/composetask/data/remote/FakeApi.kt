package com.example.composetask.data.remote

import kotlinx.coroutines.delay

class FakeApi {

    suspend fun fetchTask(): List<Task>{
        delay(1000)
        return listOf(
            Task(1, "Learn Flow", false),
            Task(2, "Practice Compose", false)
        )
    }

}