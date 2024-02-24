package com.hakanbaysal20.contactsappmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hakanbaysal20.contactsappmvvm.data.repository.ContactsDaoRepository

class AddPersonViewModel : ViewModel() {

    val cRepo = ContactsDaoRepository()
    fun addPerson(personName:String,personNumber:String) {
        cRepo.addPersonButton(personName,personNumber)
    }
}