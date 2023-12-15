package com.hakanbaysal20.ilkproje.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.abutton.setOnClickListener {
            val intent = Intent(this@MainActivity,ActivityB::class.java)
            startActivity(intent)
        }
    }
}