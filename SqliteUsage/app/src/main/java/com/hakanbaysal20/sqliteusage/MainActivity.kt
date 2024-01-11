package com.hakanbaysal20.sqliteusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hakan = Person(3,"Hakan","0101",23,1.90)
      //  Persondao().addPerson(DatabaseAccess(applicationContext),hakan)
        val dba = DatabaseAccess(applicationContext)
     //   Persondao().updatePerson(dba,hakan)
    //    Persondao().deletePerson(dba,1)
        val personList = Persondao().getContacts(dba)
      //  val personSearchList = Persondao().searchContact(dba,"Farukiyt")
        val personRandomList = Persondao().getRandom(dba)
        for (k in personRandomList){
            Log.e("ad",k.person_name)
            Log.e("numara",k.person_number)
            Log.e("yaş",k.person_age.toString())
            Log.e("boy",k.person_height.toString())
            Log.e("No",k.person_no.toString())
        }

    }
}