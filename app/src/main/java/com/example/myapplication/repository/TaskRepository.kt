
package com.example.repository

import com.example.model.Task

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
}
