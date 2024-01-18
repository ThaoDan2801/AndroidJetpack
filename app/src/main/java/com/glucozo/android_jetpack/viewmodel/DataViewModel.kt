package com.glucozo.android_jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var number = MutableLiveData<Int>(0)

    fun updateNumber(){
        number.value = number.value!!.plus(1)
    }
}