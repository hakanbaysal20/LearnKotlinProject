package com.hakanbaysal20.contactsappmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.hakanbaysal20.contactsappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}