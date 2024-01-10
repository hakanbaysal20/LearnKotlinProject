package com.hakanbaysal20.sqliteusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hakan = Person(0,"Hakan","0541",23,1.90)
        Persondao().addPerson(DatabaseAccess(applicationContext),hakan)
    }
}