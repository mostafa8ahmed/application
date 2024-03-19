
package com.example.repository

import com.example.model.Task

class TaskRepositoryImpl : TaskRepository {
    private val tasks = mutableListOf<Task>()

    override fun getAllTasks(): List<Task> {
        return tasks
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }
}
