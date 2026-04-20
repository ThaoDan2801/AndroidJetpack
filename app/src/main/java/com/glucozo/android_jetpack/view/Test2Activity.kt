package com.glucozo.android_jetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.glucozo.android_jetpack.R

class Test2Activity : AppCompatActivity() {
    val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        Log.d(TAG, "onCreate2: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart2: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume2: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause2: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop2: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy2: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart2: ")
    }
}