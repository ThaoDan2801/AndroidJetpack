package com.glucozo.android_jetpack.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glucozo.android_jetpack.databinding.ItemStudentBinding
import com.glucozo.android_jetpack.model.Student

interface StudentClick {
    fun onClick(position: Student)
}

class StudentDiff(
    private val oldStudent: List<Student>,
    private val newStudent: List<Student>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldStudent.size

    override fun getNewListSize() = newStudent.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean { // so sanh id truoc, neu dung thi moi goi areContentsTheSame
        return oldStudent[oldItemPosition].id == newStudent[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStudent[oldItemPosition].id == newStudent[newItemPosition].id
                && oldStudent[oldItemPosition].name == newStudent[newItemPosition].name
                && oldStudent[oldItemPosition].age == newStudent[newItemPosition].age
                && oldStudent[oldItemPosition].avatar == newStudent[newItemPosition].avatar

    }

}


class StudentAdapter(
    val callback: StudentClick

) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val students = arrayListOf<Student>()

    fun updateStudents(newStudents: List<Student>) {
        val diffCheck = StudentDiff(students, newStudents)
        val diffResult = DiffUtil.calculateDiff(diffCheck)
        students.clear()
        students.addAll(newStudents)
        diffResult.dispatchUpdatesTo(this)
    }

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
        holder.itemView.setOnClickListener{
            callback.onClick(students[position])
        }
    }
}