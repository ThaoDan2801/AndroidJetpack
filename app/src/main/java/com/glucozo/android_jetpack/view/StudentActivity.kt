package com.glucozo.android_jetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glucozo.android_jetpack.databinding.ActivityStudentBinding
import com.glucozo.android_jetpack.model.Student
import com.glucozo.android_jetpack.view.adapter.StudentAdapter
import com.glucozo.android_jetpack.view.adapter.StudentClick
import com.glucozo.android_jetpack.viewmodel.StudentViewModel

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    private val viewModel: StudentViewModel by viewModels()
    private val studentAdapter = StudentAdapter(object : StudentClick{
        override fun onClick(student: Student) {
            binding.editId.setText(student.id.toString())
            binding.edtName.setText(student.name)
            binding.edtAge.setText(student.age)
            binding.edtAvatar.setText(student.avatar)
        }

    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.students.observe(this) {
            studentAdapter.updateStudents(it)
        }
        binding.rcStudent.adapter = studentAdapter
        binding.rcStudent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.btnAdd.setOnClickListener {
            val student = Student(
                binding.editId.text.toString().toInt(),
                binding.edtName.text.toString(),
                binding.edtAge.text.toString(),
                "https://nld.mediacdn.vn/2020/12/19/hoa-hau-do-thi-ha-9-16083440684032031661253.jpg"
            )
            viewModel.addStudent(student)
        }

        binding.btnEdit.setOnClickListener {
            val student = Student(
                binding.editId.text.toString().toInt(),
                binding.edtName.text.toString(),
                binding.edtAge.text.toString(),
                "https://nld.mediacdn.vn/2020/12/19/hoa-hau-do-thi-ha-9-16083440684032031661253.jpg"
            )
            viewModel.updateStudent(student)
        }

        setupSwipeToDelete()


    }

    private fun setupSwipeToDelete() {
        val itemTouchHelperCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val swipePosition = viewHolder.adapterPosition
                val student = viewModel.students.value?.get(swipePosition) ?: Student(-1)
                student?.let {
                    viewModel.deleteStudent(it.id)
                }
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(binding.rcStudent)
    }
}