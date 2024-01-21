package com.glucozo.android_jetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.glucozo.android_jetpack.databinding.ActivityTaskBinding
import com.glucozo.android_jetpack.model.Task
import com.glucozo.android_jetpack.view.adapter.TaskAdapter
import com.glucozo.android_jetpack.viewmodel.TaskViewModel

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding
    private val viewModel by viewModels<TaskViewModel>()
    private val taskAdapter = TaskAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val task = Task(
                name = binding.edtName.text.toString(),
                deadline = binding.edtDeadline.text.toString(),
                description = binding.edtDescription.text.toString()
            )
            viewModel.insertTask(task)
        }
        binding.btnEdit.setOnClickListener {
            val task = Task(
                id = binding.edtId.text.toString().toInt(),
                name = binding.edtName.text.toString(),
                deadline = binding.edtDeadline.text.toString(),
                description = binding.edtDescription.text.toString()
            )
            viewModel.updateTask(task)
        }
        binding.btnDelete.setOnClickListener {

            viewModel.deleteTask(binding.edtId.text.toString().toInt())
        }
        binding.rvTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTask.adapter = taskAdapter

        viewModel.tasks.observe(this) {
            taskAdapter.submitList(it)
        }
    }
}