package com.example.composetask.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier


@Composable
fun TaskScreen(viewModel: TaskViewModel, modifier: Modifier = Modifier) {
    val state by viewModel.state.collectAsState()
    if (state.isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn(modifier = modifier) {
            items(state.tasks) { task ->
                Text(task.title)
            }
        }
    }
}