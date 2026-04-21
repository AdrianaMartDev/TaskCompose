package com.example.composetask.data

import com.example.composetask.data.local.TaskDao
import com.example.composetask.data.mapper.toDomain
import com.example.composetask.data.mapper.toEntity
import com.example.composetask.data.remote.FakeApi
import com.example.composetask.data.remote.Task
import com.example.composetask.domain.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao,
    private val api: FakeApi
): TaskRepository {

    override fun getTasks(): Flow<List<Task>> {
        return  dao.getTasks()
            .map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun sync() {
        val remote = api.fetchTask()
        remote.forEach {
            dao.insert(it.toEntity())
        }
    }

}