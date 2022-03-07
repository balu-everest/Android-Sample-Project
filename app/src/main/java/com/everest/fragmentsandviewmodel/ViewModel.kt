package com.everest.fragmentsandviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    private val _update = MutableLiveData(false)
    val update: LiveData<Boolean> = _update

    fun incrementCount() {
        val value = _count.value ?: 0
        _count.postValue(value + 1)
    }

    fun showUpdateScreen() {
        val value = _update.value ?: false
        _update.postValue(!value)

    }
}