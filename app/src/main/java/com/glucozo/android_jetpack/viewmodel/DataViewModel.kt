package com.glucozo.android_jetpack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glucozo.android_jetpack.util.Event
import com.glucozo.android_jetpack.util.SingleLiveEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class DataViewModel : ViewModel() {
    //SAI CO CHE MVVM
//    var number = MutableLiveData<Int>(0)
//
//    fun updateNumber(){
//        number.value = number.value!!.plus(1)
//    }


    //co che backing field
    private val _number = MutableLiveData(0)
    val number : LiveData<Int>
        get() = _number
//one time event
    private val _showToast = MutableLiveData<Event<Boolean>>()
//    private val _showToast = MutableLiveData<Boolean>(false)
//    val showToast : LiveData<Boolean>
    val showToast : LiveData< Event<Boolean>>
        get() = _showToast

    private val _startActivity = SingleLiveEvent<Boolean>()
//    private val _startActivity = MutableLiveData<Boolean>(false)
    val startActivity : SingleLiveEvent<Boolean>
//    val startActivity : LiveData<Boolean>
        get() = _startActivity

    val message = MutableLiveData<String>()


    private val _toastChannel = Channel<Boolean> {  }//onetime event co san cua kotlin
    val toastChannel = _toastChannel.receiveAsFlow()

    fun updateNumber(){
        _number.value = _number.value!!.plus(1)
    }

    fun getText(){
        Log.d("thaont", "current message ${message.value}")
    }

    fun showToast(){
        _showToast.value = Event((true))// run immediately => chay ngay lap tuc
        _showToast.postValue(Event(true))// => handle.post // chay sau 1 chut, nhung khong anh huong den performance
//        _showToast.postValue(false)
    }
    fun startActivity(){
        _startActivity.value = true
    }

}