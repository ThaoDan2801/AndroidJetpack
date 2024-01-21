package com.glucozo.android_jetpack.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glucozo.android_jetpack.databinding.ActivityMainBinding
import com.glucozo.android_jetpack.di.Car
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var share: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        car.drive()
//        val driver = Driver("thao")
//        val car = Car( driver)
//        val car2 = Car()
//        car2.setDriver(driver)
//        car.drive()

        setContentView(binding.root)
    }
}