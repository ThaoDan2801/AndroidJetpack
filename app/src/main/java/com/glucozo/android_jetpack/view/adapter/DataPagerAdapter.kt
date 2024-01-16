package com.glucozo.android_jetpack.view.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.glucozo.android_jetpack.view.fragment.OneFragment
import com.glucozo.android_jetpack.view.fragment.TwoFragment
import java.lang.IllegalArgumentException

class DataPagerAdapter(activity: AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> throw IllegalArgumentException("Unknown fragment")
        }
    }

}