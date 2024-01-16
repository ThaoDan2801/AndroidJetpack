package com.glucozo.android_jetpack.view

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.glucozo.android_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)




        setContentView(binding.root)
    }
}