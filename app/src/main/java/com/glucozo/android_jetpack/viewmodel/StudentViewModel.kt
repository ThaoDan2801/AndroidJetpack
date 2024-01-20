package com.glucozo.android_jetpack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glucozo.android_jetpack.model.Student

class StudentViewModel : ViewModel() {
    private val arrStudent = arrayListOf<Student>()

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>>
        get() = _students


    fun addStudent(student: Student) {
        arrStudent.add(student)
        _students.postValue(arrStudent)
    }

    fun updateStudent(student: Student) {
        // tim duoc index cua student muon update, sau do set
        val index = arrStudent.indexOf(student)
        if (index >= 0) {
            arrStudent[index] = student
        } else {
            Log.d("thaont", "Student chua ton tai")
        }
        _students.postValue(arrStudent)

    }

    fun deleteStudent(id: Int) {
        val index = arrStudent.indexOf(Student(id))
        if (index >= 0) {
            arrStudent.removeAt(index)
        }
        _students.postValue(arrStudent)
    }
}