package com.hakanbaysal20.mvvmusages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hakanbaysal20.mvvmusages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivityObject = this

        viewModel.equals.observe(this,{equals ->
            binding.equalsTo = equals
        })
    }
    fun clickSumButton(firstNumber:String,secondNumber:String) {
        viewModel.sum(firstNumber,secondNumber)
    }
    fun clickButtonMultiplication(firstNumber: String,secondNumber: String) {
        viewModel.multiplication(firstNumber,secondNumber)
    }
}