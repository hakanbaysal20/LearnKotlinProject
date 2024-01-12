package com.hakanbaysal20.bayrakquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.bayrakquiz.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        copyDatabase()
    }
    private fun copyDatabase() {
        val db = DatabaseCopyHelper(applicationContext)

        try {
            db.createDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }


    }

}