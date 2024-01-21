package com.glucozo.android_jetpack.di

import android.util.Log
import javax.inject.Inject

data class Car @Inject constructor(
    val driver: Driver //phụ thuộc
) {

    fun drive() {
        Log.d("thaont", "Car drive by ${driver.name}")
    }
}
