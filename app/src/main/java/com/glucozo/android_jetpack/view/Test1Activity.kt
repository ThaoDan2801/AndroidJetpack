package com.glucozo.android_jetpack.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.glucozo.android_jetpack.R
import com.glucozo.android_jetpack.databinding.ActivityStudentBinding
import com.glucozo.android_jetpack.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    val TAG = "Activity"
    lateinit var binding:ActivityTest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_test1)
        onClick()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity :onStart1: ")
    }
    fun onClick(){
        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, Test2Activity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume1: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause1: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop1: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy1: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart1: ")
    }
}