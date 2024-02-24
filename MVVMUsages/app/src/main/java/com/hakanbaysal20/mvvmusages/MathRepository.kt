package com.hakanbaysal20.mvvmusages

import androidx.lifecycle.MutableLiveData

class MathRepository {
    var result = MutableLiveData<String>()
    init {
        result = MutableLiveData<String>("0")
    }

    fun fetchResult():MutableLiveData<String> {
        return result
    }
    fun sum(firstNumber:String,secondNumber:String) {
        result.value = (firstNumber.toInt() + secondNumber.toInt()).toString()

    }
    fun multiplication(firstNumber:String,secondNumber:String) {
        result.value = (firstNumber.toInt() * secondNumber.toInt()).toString()
    }
}