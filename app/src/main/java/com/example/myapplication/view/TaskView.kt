
package com.example.view

import com.example.model.Task

interface TaskView {
    fun showTasks(tasks: List<Task>)
    fun showError(message: String)
}
