package com.hakanbaysal20.gradesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.gradesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:GradesRVAdapter
    private lateinit var gradeList:ArrayList<Grade>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gradeRv.setHasFixedSize(true)
        binding.gradeRv.layoutManager = LinearLayoutManager(applicationContext)
    }
}