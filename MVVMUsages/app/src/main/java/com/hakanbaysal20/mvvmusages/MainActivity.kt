package com.hakanbaysal20.mvvmusages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hakanbaysal20.mvvmusages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivityObject = this
        binding.equalsTo = "0"
    }
    fun buttonSumClick(firstNumber:String,secondNumber:String) {

        binding.equalsTo = (firstNumber.toInt() + secondNumber.toInt()).toString()
    }
    fun clickButtonMultiplication(firstNumber: String,secondNumber: String) {
        binding.equalsTo = (firstNumber.toInt() * secondNumber.toInt()).toString()
    }
}