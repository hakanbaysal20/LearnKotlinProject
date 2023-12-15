package com.hakanbaysal20.ilkproje.context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityContextBinding

class Context : AppCompatActivity() {
    private lateinit var binding:ActivityContextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityContextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button8.setOnClickListener {
            Toast.makeText(this@Context,"Merhaba",Toast.LENGTH_SHORT).show()
        //context : applicationContext
        //context : this
        //context : this@Context
        }
    }
}