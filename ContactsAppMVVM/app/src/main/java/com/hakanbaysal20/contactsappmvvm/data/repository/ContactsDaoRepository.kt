package com.hakanbaysal20.contactsappmvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hakanbaysal20.contactsappmvvm.data.entity.Person

class ContactsDaoRepository {
    var personsList:MutableLiveData<List<Person>>
    init {
        personsList = MutableLiveData()
    }
    fun addPersonButton(personName:String,personNumber:String) {
        Log.e("Person Name",personName)
        Log.e("Person Number",personNumber)
    }
    fun updateButton(personId:Int,personName:String,personNo:String) {
        Log.e("Person Name",personName)
        Log.e("Person Number",personNo)
    }
    fun searchPerson(word:String) {

    }
    fun deletePerson(personId:Int) {
        Log.e("silme",personId.toString())
    }
    fun getContacts() {

        val contactsList = ArrayList<Person>()
        val k = Person(1,"Hakan","333")
        val k1 = Person(2,"Baysal","333")
        val k2 = Person(3,"TR","333")
        val k3 = Person(5,"CM","333")
        contactsList.add(k)
        contactsList.add(k1)
        contactsList.add(k2)
        contactsList.add(k3)
        personsList.value = contactsList
    }
    fun getContactsVM():MutableLiveData<List<Person>> {
        return personsList
    }
}