package com.hakanbaysal20.notesappvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.notesappvolley.databinding.ActivityMainBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}