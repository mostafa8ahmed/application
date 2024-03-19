
package com.example.view

import com.example.model.Task
import com.example.repository.TaskRepository

class TaskPresenter(private val view: TaskView, private val repository: TaskRepository) {
    fun getAllTasks() {
        val tasks = repository.getAllTasks()
        if (tasks.isNotEmpty()) {
            view.showTasks(tasks)
        } else {
            view.showError("No tasks found.")
        }
    }

    fun addTask(taskTitle: String) {
        val taskId = repository.getAllTasks().size + 1
        val task = Task(taskId, taskTitle)
        repository.addTask(task)
        getAllTasks() // Refresh the view
    }
}
