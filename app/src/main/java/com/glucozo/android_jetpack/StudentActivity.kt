package com.glucozo.android_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glucozo.android_jetpack.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}