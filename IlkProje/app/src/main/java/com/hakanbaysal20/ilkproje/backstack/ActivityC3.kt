package com.hakanbaysal20.ilkproje.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityC3Binding

class ActivityC3 : AppCompatActivity() {
    private lateinit var binding:ActivityC3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityC3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cbutton.setOnClickListener {
            var intent = Intent(this@ActivityC3,ActivityD::class.java)
            startActivity(intent)
        }
    }
}