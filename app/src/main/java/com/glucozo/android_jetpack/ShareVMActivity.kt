package com.glucozo.android_jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glucozo.android_jetpack.databinding.ActivityShareVmBinding
import com.glucozo.android_jetpack.view.adapter.DataPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ShareVMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShareVmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareVmBinding.inflate(layoutInflater)
        setupView()
        setContentView(binding.root)
    }
    private fun setupView(){

        binding.viewpager.adapter = DataPagerAdapter(this)
        val tabTitles = arrayOf("One", "Two")
        TabLayoutMediator(binding.tabMain, binding.viewpager) {
                tab, position -> tab.text = tabTitles[position]
        }.attach()
    }
}