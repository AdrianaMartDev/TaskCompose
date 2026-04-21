package com.example.composetask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetask.domain.AddTaskUseCase
import com.example.composetask.domain.GetTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTask: GetTaskUseCase,
    private val addTask: AddTaskUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TaskState())
    val state: StateFlow<TaskState> = _state

    init {
        observeTasks()
        viewModelScope.launch {
            addTask()
        }
    }

    private fun observeTasks() {
        viewModelScope.launch {
            getTask().collect { tasks ->
                _state.update {
                    it.copy(tasks = tasks, isLoading = false)
                }
            }
        }
    }
}