package com.example

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.model.Task
import com.example.myapplication.R
import com.example.repository.TaskRepositoryImpl
import com.example.view.TaskPresenter
import com.example.view.TaskView

class MainActivity : AppCompatActivity(), TaskView {

    private lateinit var presenter: TaskPresenter
    private lateinit var taskListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskListView = findViewById(R.id.taskListView)
        presenter = TaskPresenter(this, TaskRepositoryImpl())

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            presenter.addTask("New Task")
        }

        presenter.getAllTasks()
    }

    override fun showTasks(tasks: List<Task>) {
        val taskTitles = tasks.map { it.title }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskTitles)
        taskListView.adapter = adapter
    }

    override fun showError(message: String) {
        Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
    }
}
