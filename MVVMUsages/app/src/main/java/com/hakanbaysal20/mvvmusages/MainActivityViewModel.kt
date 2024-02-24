package com.hakanbaysal20.mvvmusages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var equals = MutableLiveData<String>()
    var mRepo = MathRepository()

    init {
        equals = mRepo.fetchResult()
    }

    fun sum(firstNumber:String,secondNumber:String) {
        mRepo.sum(firstNumber,secondNumber)
    }
    fun multiplication(firstNumber: String,secondNumber: String) {
        mRepo.multiplication(firstNumber,secondNumber)
    }

}