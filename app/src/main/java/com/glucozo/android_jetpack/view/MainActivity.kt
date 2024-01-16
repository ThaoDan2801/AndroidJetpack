package com.glucozo.android_jetpack.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glucozo.android_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)
    }
}