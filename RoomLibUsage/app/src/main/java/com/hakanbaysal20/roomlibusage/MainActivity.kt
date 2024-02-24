package com.hakanbaysal20.roomlibusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db:IDatabase
    private lateinit var cDao:ContactsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = IDatabase.databaseAccess(this)!!
        cDao = db.getContactsDao()
        getContacts()
    }

    fun getContacts() {
        val job = CoroutineScope(Dispatchers.Main).launch{
            val responseList = cDao.getContacts()
            for (i in responseList){
                Log.e("personId",i.personId.toString())
                Log.e("personName",i.personName)
                Log.e("personNo",i.personNo)
            }
        }
    }
}