package com.hakanbaysal20.ilkproje.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private lateinit var binding:ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bbutton.setOnClickListener {
            val intent = Intent(this@ActivityB,ActivityC3::class.java)
            startActivity(intent)
        }
    }
}