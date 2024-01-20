package com.glucozo.android_jetpack.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glucozo.android_jetpack.databinding.ItemStudentBinding
import com.glucozo.android_jetpack.model.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val students = arrayListOf<Student>()

    class ViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.student = student
            binding.executePendingBindings() // update ui
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = students.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        students[position].let {
            holder.bind(it)
        }
    }
}